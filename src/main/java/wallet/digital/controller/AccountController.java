package wallet.digital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wallet.digital.entity.Account;
import wallet.digital.repository.AccountRepository;


@RestController
@RequestMapping("/public/account")
public class AccountController {

    private  final AccountRepository accountRepository;

    public AccountController( AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/balance")
    public ResponseEntity<Long> getBalance(@RequestParam String username) {
        Account account = accountRepository.findByUsername_Username(username)
                .orElseThrow(()-> new RuntimeException("Não existe conta para esse Username: " + username));

        ResponseEntity<Long> response = new ResponseEntity<>(account.getBalance(), HttpStatus.OK);

        return response;
    }
}
