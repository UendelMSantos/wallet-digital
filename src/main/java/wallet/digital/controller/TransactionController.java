package wallet.digital.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wallet.digital.DTOs.AccountDTO;
import wallet.digital.DTOs.ResponseTransactionsDTO;
import wallet.digital.DTOs.TransactionDTO;
import wallet.digital.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/new-transaction")
    public ResponseEntity<String> newTransaction(@RequestBody TransactionDTO transactionDTO) {
        String response = transactionService.newTransaction(transactionDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseTransactionsDTO>> getAllTransactionsByUsername(@RequestParam String username) {
        List<ResponseTransactionsDTO> responseTransactionsDTOS = transactionService.getAllTransactionsByUsername(username);
        return ResponseEntity.ok(responseTransactionsDTOS);
    }


}
