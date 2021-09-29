package banking.loan.dto;


import banking.commons.dto.IndividualDTO;
import banking.loan.model.LoanStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AccountLoanDTO {

    @NotNull
    private String iban;
    private double loanAmount;
    private int individualId;
    private int period;
    private double interestRate;
    private Date startDate;
    private LoanStatus loanStatus;
    private double principal;
    private IndividualDTO individualDTO;
}
