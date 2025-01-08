package SimBankAPI.Backend_SimBank.Repository;

import SimBankAPI.Backend_SimBank.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByAccountId(int account_id);
}
