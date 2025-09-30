package wallet.digital.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wallet.digital.DTOs.UserDTO;
import wallet.digital.entity.Account;
import wallet.digital.entity.Authority;
import wallet.digital.entity.User;
import wallet.digital.repository.AccountRepository;
import wallet.digital.repository.AuthorityRepository;
import wallet.digital.repository.UserRepository;

import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final AccountRepository accountRepository;
    private  Random random = new Random();

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(
            UserRepository userRepository,
            AuthorityRepository authorityRepository,
            AccountRepository accountRepository
    ) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.accountRepository = accountRepository;
    }

    private String generateRandomAccountNumber() {
        int number = 10000000 + random.nextInt(90000000);
        return String.valueOf(number);
    }


    private String createAccount(User user) {
        Account account = new Account();

        account.setUsername(user);
        account.setBalance(100L);
        account.setAgency("0001");
        account.setAccountNumber(generateRandomAccountNumber());

        accountRepository.save(account);

        return "Conta criada com sucesso!";

    }



    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(true);
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());

        User userSaved = userRepository.save(user);

        Authority authority = new Authority();

        authority.setUsername(userDTO.getUsername());
        authority.setAuthority("ROLE_ADMIN");

        authorityRepository.save(authority);

        this.createAccount(userSaved);

        UserDTO response = new UserDTO();
        response.setUsername(userSaved.getUsername());
        response.setName(userSaved.getName());
        response.setLastname(userSaved.getLastname());

        return response;
    }

    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Username not found!")
        );

        UserDTO response = new UserDTO();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setName(user.getName());
        response.setLastname(user.getLastname());

        return response;


    }

}
