package SimBankAPI.Backend_SimBank.Service;

import SimBankAPI.Backend_SimBank.Entity.Transaction;
import SimBankAPI.Backend_SimBank.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction newTransaction){
        return transactionRepository.save(newTransaction);
    }

    public void deleteTransaction(Transaction transaction){
        transactionRepository.delete(transaction);
    }
}
