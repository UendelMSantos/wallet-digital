package wallet.digital.DTOs;



import java.time.LocalDateTime;

public class ResponseTransactionsDTO {

    private String senderUsername;

    private String senderName;

    private String receiverUsername;

    private String receiverName;

    private Long value;

    private LocalDateTime createdAt = LocalDateTime.now();

    public  ResponseTransactionsDTO() {}

    public ResponseTransactionsDTO(String senderUsername, String senderName, String receiverUsername, String receiverName, Long value, LocalDateTime createdAt) {
        this.senderUsername = senderUsername;
        this.senderName = senderName;
        this.receiverUsername = receiverUsername;
        this.receiverName = receiverName;
        this.value = value;
        this.createdAt = createdAt;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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
}
