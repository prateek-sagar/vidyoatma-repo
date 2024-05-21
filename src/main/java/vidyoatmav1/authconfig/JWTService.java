package vidyoatmav1.authconfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JWTService {

    @Value("${application.security.jwt.security-key}")
    private String key;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    /*
     * Method to extract the username from
     * the jwt by the help of extract claim
     * method
     */
    public String extractUserName(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    /*
     * Validate the token on the basis of
     * username for the token to the issuer
     * is token expired or not
     */
    public boolean isValidToken(String jwt, UserDetails userDetails) {
        final String username = extractUserName(jwt);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /*
     * Method to return the sign in key for the token
     */
    private SecretKey getSigninKey() {

        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /*
     * Method for extract claim
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claim = extractAllClaims(token);
        return claimResolver.apply(claim);
    }

    /*
     * Method for generate token
     */
    public String generateToken(
            Map<String, Object> extractClaims,
            UserDetails userDetails) {
        return buildToken(extractClaims, userDetails, jwtExpiration);
    }

    /*
     * Method to generate referesh token
     */
    public String generateRefreshToken(Map<String, Object> extractClaims,
            UserDetails userDetails) {
        return buildToken(extractClaims, userDetails, refreshExpiration);
    }

    private String buildToken(Map<String, Object> extractClaims, UserDetails userDetails, long expiration) {
        return Jwts
                .builder()
                .claims(extractClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigninKey())
                .compact();
    }

    /*
     * Generate token with Userdetails only
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return generateRefreshToken(new HashMap<>(), userDetails);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}