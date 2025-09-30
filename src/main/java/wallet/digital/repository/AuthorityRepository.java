package wallet.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wallet.digital.entity.Authority;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    List<Authority> findByUsername(String username);

}
