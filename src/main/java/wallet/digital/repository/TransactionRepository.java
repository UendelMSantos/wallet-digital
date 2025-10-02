package wallet.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wallet.digital.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t " +
            "WHERE (t.receiverUsername = :username OR t.senderUsername = :username) " +
            "AND ((CAST(:start AS TIMESTAMP) IS NULL) OR (t.createdAt >= :start)) " +
            "AND ((CAST(:end AS TIMESTAMP) IS NULL) OR (t.createdAt <= :end))")
    List<Transaction> findAllTransactionsByUsernameAndDateRange(@Param("username") String username,
                                                                @Param("start") LocalDateTime start,
                                                                @Param("end") LocalDateTime end);
}
