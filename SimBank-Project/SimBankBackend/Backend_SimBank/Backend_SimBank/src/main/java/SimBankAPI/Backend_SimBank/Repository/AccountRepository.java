package SimBankAPI.Backend_SimBank.Repository;

import SimBankAPI.Backend_SimBank.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findByCustomerId(int customer_id);
}
