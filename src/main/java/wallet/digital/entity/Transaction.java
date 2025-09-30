package wallet.digital.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_username", nullable = false)
    private String senderUsername;

    @Column(nullable = false)
    private String senderName;

    @Column(name = "receiver_username", nullable = false)
    private String receiverUsername;

    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private Long value;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Transaction() {}

    public Transaction(Long id, String senderUsername, String senderName, String receiverName, String receiverUsername,
                       Long value, LocalDateTime createdAt) {
        this.id = id;
        this.senderUsername = senderUsername;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.receiverUsername = receiverUsername;
        this.value = value;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
