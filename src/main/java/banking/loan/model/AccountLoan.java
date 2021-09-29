package banking.loan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "account_loan")
public class AccountLoan {

    @Id
    @Column(name = "iban")
    private String iban;

    private double loanAmount;
    private int individualId;

//    @Enumerated(EnumType.STRING)
    @Column(name = "period", nullable = false)
    private int period;

    private double interestRate;

    private Date startDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    private double principal;


}
