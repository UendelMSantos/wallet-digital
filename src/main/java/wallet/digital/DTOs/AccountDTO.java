package wallet.digital.DTOs;

import wallet.digital.entity.User;

public class AccountDTO {

    private String accountNumber;

    private Long balance;

    private User username;

    private String agency;

    public AccountDTO() {};

    public AccountDTO(String accountNumber, Long balance, User username, String agency) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.username = username;
        this.agency = agency;
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
}
