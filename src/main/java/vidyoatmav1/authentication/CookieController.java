package vidyoatmav1.authentication;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieController {
    public void sentHttpOnlyCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        // cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setMaxAge(1000 * 60 * 60 * 24);
        response.addCookie(cookie);
    }
}
