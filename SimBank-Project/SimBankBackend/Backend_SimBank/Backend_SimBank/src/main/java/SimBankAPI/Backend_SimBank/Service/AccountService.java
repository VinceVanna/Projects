package SimBankAPI.Backend_SimBank.Service;

import SimBankAPI.Backend_SimBank.Entity.Account;
import SimBankAPI.Backend_SimBank.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account newAccount){
        return accountRepository.save(newAccount);
    }

    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }
}
