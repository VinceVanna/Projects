package SimBankAPI.Backend_SimBank.Controller;

import SimBankAPI.Backend_SimBank.Entity.Transaction;
import SimBankAPI.Backend_SimBank.Repository.TransactionRepository;
import SimBankAPI.Backend_SimBank.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/SimBank/Transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/getAllTransactions")
    public ResponseEntity getAllTransaction(){
        return ResponseEntity.ok(this.transactionRepository.findAll());
    }

    @GetMapping("getTransactionByID/{id}")
    public Transaction getTransactionById(@PathVariable int id){
        return transactionRepository.findById(id).get();
    }

    @PostMapping("/NewTransaction")
    public Transaction saveNewTransaction(@RequestBody Transaction newTransaction) throws NoSuchAlgorithmException{
        newTransaction.setTransactionTime(LocalDateTime.now());
        return transactionService.saveTransaction(newTransaction);
    }

    @PutMapping("/UpdateTransaction/{id}")
    public Transaction updateTransaction(@PathVariable int id, @RequestBody Transaction transaction) throws NoSuchAlgorithmException{
        Transaction oldTransaction = transactionRepository.findById(id).get();
        oldTransaction.setAmountChanged(transaction.getAmountChanged());
        oldTransaction.setTransactionType(transaction.getTransactionType());
        oldTransaction.setTransactionTime(LocalDateTime.now());

        transactionService.saveTransaction(oldTransaction);
        return oldTransaction;
    }

    @DeleteMapping("/DeleteTransaction/{id}")
    public String deleteTransaction(@PathVariable int id){
        Transaction transaction = transactionRepository.findById(id).get();
        transactionService.deleteTransaction(transaction);
        return "Transaction Removed";
    }

    @GetMapping("/findAllTransactionsByAccountId/{id}")
    public List<Transaction> getAllTransationsByAccountId(@PathVariable int id){
        List<Transaction> allTransactions = transactionRepository.findByAccountId(id);
        return allTransactions;
    }
}
