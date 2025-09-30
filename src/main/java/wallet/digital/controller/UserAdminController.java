package wallet.digital.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wallet.digital.DTOs.UserDTO;
import wallet.digital.service.UserService;



@RestController
@RequestMapping("/admin")
public class UserAdminController {

    private final UserService userService;

    UserAdminController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO response = userService.createUser(userDTO);
        return ResponseEntity.ok(response);
    }


}