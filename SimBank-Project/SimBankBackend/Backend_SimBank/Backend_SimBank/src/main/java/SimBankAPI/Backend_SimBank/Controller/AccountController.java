package SimBankAPI.Backend_SimBank.Controller;

import SimBankAPI.Backend_SimBank.Entity.Account;
import SimBankAPI.Backend_SimBank.Repository.AccountRepository;
import SimBankAPI.Backend_SimBank.Repository.CustomerRepository;
import SimBankAPI.Backend_SimBank.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/SimBank/Account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerRepository customerRepository;

    public AccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity getAllAccounts(){
        return ResponseEntity.ok(this.accountRepository.findAll());
    }

    @GetMapping("/getAccountByID/{id}")
    public Account getAccountById(@PathVariable int id){
        return accountRepository.findById(id).get();
    }

    @PostMapping("/NewAccount")
    public Account saveNewAccount(@RequestBody Account newAccount) throws NoSuchAlgorithmException {
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setUpdatedAt(LocalDateTime.now());
        return accountService.saveAccount(newAccount);
    }

    @PutMapping("/UpdateAccount/{id}")
    public Account updateAccount(@PathVariable int id, @RequestBody Account account){
        Account oldAccount = accountRepository.findById(id).get();
        oldAccount.setBalance(account.getBalance());
        oldAccount.setUpdatedAt(LocalDateTime.now());
        return accountService.saveAccount((oldAccount));
    }

    @DeleteMapping("/DeleteAccount/{id}")
    public String deleteAccount(@PathVariable int id){
        Account account = accountRepository.findById(id).get();
        accountService.deleteAccount(account);
        return "Account Removed.";
    }

    @GetMapping("/findAllAccountsByCustomerId/{id}")
    public List<Account> getAllAccountsInCustomerID(@PathVariable int id){
        List<Account> allAccounts = accountRepository.findByCustomerId(id);

        return allAccounts;
    }

}
