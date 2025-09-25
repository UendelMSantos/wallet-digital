package wallet.digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import wallet.digital.entity.Authority;
import wallet.digital.entity.User;
import wallet.digital.repository.AuthorityRepository;
import wallet.digital.repository.UserRepository;

import java.util.HashSet;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class UserAdminController {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create-user")
    public Map<String, Object> createUser(@RequestBody Map<String, Object> request) {
        try {
            String username = (String) request.get("username");
            String plainPassword = String.valueOf(request.get("password"));

            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(plainPassword));
            user.setEnabled(true);

            User savedUser = userRepository.save(user);

            Authority authority = new Authority();
            authority.setUsername(username);
            authority.setAuthority("ROLE_ADMIN");

            authorityRepository.save(authority);


            return Map.of(
                    "success", true,
                    "message", "Usuário criado com sucesso!",
                    "userId", savedUser.getId(),
                    "username", username
            );

        } catch (Exception e) {
            e.printStackTrace();
            return Map.of(
                    "success", false,
                    "error", e.getMessage(),
                    "stackTrace", e.getStackTrace()
            );
        }
    }
}