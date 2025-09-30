package wallet.digital.service;

import org.springframework.stereotype.Service;
import wallet.digital.DTOs.AccountDTO;
import wallet.digital.DTOs.ResponseTransactionsDTO;
import wallet.digital.DTOs.TransactionDTO;
import wallet.digital.DTOs.UserDTO;
import wallet.digital.entity.Account;
import wallet.digital.entity.Transaction;
import wallet.digital.repository.AccountRepository;
import wallet.digital.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;




@Service
public class TransactionService {


    private final AccountRepository accountRepository;
    private final UserService userService;
    private final TransactionRepository transactionRepository;

    public TransactionService(
            AccountRepository accountRepository,
            UserService userService,
            TransactionRepository transactionRepository
    ) {
        this.accountRepository = accountRepository;
        this.userService = userService;
        this.transactionRepository = transactionRepository;
    }

    public String newTransaction(TransactionDTO transactionDTO) {
        UserDTO senderUser = userService.getUserByUsername(transactionDTO.getSenderUsername());
        UserDTO receiverUser = userService.getUserByUsername(transactionDTO.getReceiverUsername());

        Account senderAccount = accountRepository.findByUsername_Username(transactionDTO.getSenderUsername())
                .orElseThrow(() -> new RuntimeException(
                        "Não há conta disponivel para o User: " + transactionDTO.getSenderUsername()
                ));
        Account receiverAccount = accountRepository.findByUsername_Username(transactionDTO.getReceiverUsername())
                .orElseThrow(() -> new RuntimeException(
                        "Não há conta disponivel para o User: " + transactionDTO.getReceiverUsername()
                ));

        if(transactionDTO.getValue() > senderAccount.getBalance()){
           new RuntimeException("Transferência impossibilitada no momento");
        }

        senderAccount.setBalance(senderAccount.getBalance() - transactionDTO.getValue());
        accountRepository.save(senderAccount);
        receiverAccount.setBalance(receiverAccount.getBalance() + transactionDTO.getValue());
        accountRepository.save(receiverAccount);

        Transaction newTransaction = new Transaction();
        newTransaction.setSenderUsername(transactionDTO.getSenderUsername());
        newTransaction.setReceiverUsername(transactionDTO.getReceiverUsername());
        newTransaction.setValue(transactionDTO.getValue());
        newTransaction.setSenderName(senderUser.getName());
        newTransaction.setReceiverName(receiverUser.getName());

        transactionRepository.save(newTransaction);

        return "Transaction created";
    }


    public List<ResponseTransactionsDTO> getAllTransactionsByUsername(String Username){

        List<Transaction> transactions = transactionRepository.findAllTransactionsByUsername(Username);

        List<ResponseTransactionsDTO> responseTransactions = new ArrayList<>();

        for(Transaction transaction : transactions){
            ResponseTransactionsDTO dto = new ResponseTransactionsDTO();

            dto.setCreatedAt(transaction.getCreatedAt());
            dto.setSenderName(transaction.getSenderName());
            dto.setReceiverName(transaction.getReceiverName());
            dto.setValue(transaction.getValue());
            dto.setSenderUsername(transaction.getSenderUsername());
            dto.setReceiverUsername(transaction.getReceiverUsername());

            responseTransactions.add(dto);
        }
        return responseTransactions;
    }
}
