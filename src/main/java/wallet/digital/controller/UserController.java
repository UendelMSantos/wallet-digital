package wallet.digital.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
                "name", jwt.getClaimAsString("name"),
                "lastname", jwt.getClaimAsString("lastname"),
                "userId", jwt.getClaim("user_id"),
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

    @GetMapping("/test")
    public Map<String, Object> test(
            @AuthenticationPrincipal Jwt jwt,
            @RequestHeader("Authorization") String authHeader) {

        if (jwt == null) {
            return Map.of("error", "JWT is null", "header", authHeader);
        }

        return Map.of(
                "status", "Token válido!",
                "subject", jwt.getSubject(),
                "claims", jwt.getClaims(),
                "expiresAt", jwt.getExpiresAt(),
                "issuedAt", jwt.getIssuedAt()
        );
    }
}
