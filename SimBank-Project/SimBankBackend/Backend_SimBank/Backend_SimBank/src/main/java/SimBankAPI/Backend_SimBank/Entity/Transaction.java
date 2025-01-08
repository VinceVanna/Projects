package SimBankAPI.Backend_SimBank.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "transaction_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "amount_changed")
    private double amountChanged;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;

}
