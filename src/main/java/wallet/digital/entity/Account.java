package wallet.digital.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private Long balance;

    @ManyToOne(fetch = FetchType.LAZY)
    private User username;

    @Column(nullable = false, length = 10)
    private String agency;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Account() {}

    public Account(Long id, String accountNumber, Long balance, User username, String agency, LocalDateTime createdAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.username = username;
        this.agency = agency;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
