package wallet.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wallet.digital.entity.Account;
import wallet.digital.entity.User;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByUsername_Username(String username);

}
