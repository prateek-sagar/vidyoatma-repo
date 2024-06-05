package vidyoatmav1.authconfig;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import vidyoatmav1.authentication.CookieController;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final JWTService jwtService;
    private final CookieController cookieController;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        // request
        if (request.getServletPath().contains("api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Header from the request
        System.out.println(request);
        String access = null;
        String refresh = null;
        final Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            filterChain.doFilter(request, response);
            return;
        }
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("access-token")) {
                    access = cookie.getValue();
                }
                if (cookie.getName().equals("refresh-token")) {
                    refresh = cookie.getValue();
                }
            }
        }
        final String jwt;
        final String refreshjwt;

        // username from the jwt token
        final String userName;
        // check for the header is null and any other type of authorization

        // if the condition is not true
        jwt = access;
        refreshjwt = refresh;
        System.out.println(jwt);
        userName = jwtService.extractUserName(jwt);
        System.out.println(userName);
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            // check validity for the token

            // System.out.println(userDetails);
            if (jwtService.isValidToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                // System.out.println("1:" + authToken);
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));
                // System.out.println(authToken);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else if (jwtService.isValidToken(refreshjwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                // System.out.println("1:" + authToken);
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));
                // System.out.println(authToken);
                SecurityContextHolder.getContext().setAuthentication(authToken);
                cookieController.sentHttpOnlyCookie(response, "access-token", jwtService.generateToken(userDetails),
                        24 * 60 * 60);
                cookieController.sentHttpOnlyCookie(response, "refresh-token",
                        jwtService.generateRefreshToken(userDetails), 24 * 60 * 60 * 7);
            }
        }
        // System.out.println("out");

        filterChain.doFilter(request, response);
    }

}
