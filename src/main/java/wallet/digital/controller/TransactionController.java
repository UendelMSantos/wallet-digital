package wallet.digital.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wallet.digital.DTOs.AccountDTO;
import wallet.digital.DTOs.ResponseTransactionsDTO;
import wallet.digital.DTOs.TransactionDTO;
import wallet.digital.service.TransactionService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
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

    @GetMapping
    public ResponseEntity<List<ResponseTransactionsDTO>> getAllTransactionsByUsername(
            @RequestParam String username,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<ResponseTransactionsDTO> response =
                transactionService.getAllTransactionsByUsername(username, startDate, endDate);

        return ResponseEntity.ok(response);
    }



}
