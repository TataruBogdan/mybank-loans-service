package banking.loan.service;

import banking.commons.dto.AccountLoanDTO;

import java.util.List;
import java.util.Optional;

public interface AccountLoanService {

    double interestRate = 6.00;

    List<AccountLoanDTO> getAll();
    Optional<AccountLoanDTO> getByIban(String iban);
    List<AccountLoanDTO> getAllByIndividualId(int individualId);
    AccountLoanDTO createIndividualLoanAccount(int individualId, int period, int amount);
//    AccountLoanDTO creditAccountLoan(String iban, Double amount);
    void deleteAccountByIban(String iban);


}
