package bank.loan.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Period;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_loan")
public class AccountLoan implements Serializable {

    @Id
    @Column(name = "iban")
    private String iban;

    private double loanAmount;
    private int individualId;

//    @Enumerated(EnumType.STRING)
    @Column(name = "period", nullable = false)
    private Period period;

    private double interestRate;
    private String interestReturn;
    private Date startDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    private double principal;


}
