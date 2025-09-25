package wallet.digital.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "username", jwt.getSubject(),
                "authorities", jwt.getClaimAsStringList("authorities"),
                "scopes", jwt.getClaimAsStringList("scope")
        );
    }

    @GetMapping("/protected")
    public Map<String, String> getProtectedResource() {
        return Map.of(
                "message", "Este é um recurso protegido!",
                "timestamp", java.time.Instant.now().toString()
        );
    }
}
