package wallet.digital.DTOs;


public class TransactionDTO {

    private String senderUsername;
    private String receiverUsername;

    private Long value;

    public TransactionDTO() {}

    public TransactionDTO(String senderUsername, String receiverUsername, Long value) {
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.value = value;
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

}
