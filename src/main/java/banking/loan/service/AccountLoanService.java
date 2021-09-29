package banking.loan.service;

import banking.loan.dto.AccountLoanDTO;

import java.util.List;
import java.util.Optional;

public interface AccountLoanService {

    double interestRate = 6.00;

    List<AccountLoanDTO> getAll();
    Optional<AccountLoanDTO> getByIban(String iban);
    List<AccountLoanDTO> getAllByIndividualId(int individualId);
    AccountLoanDTO updateBalanceAccount(String iban, Double balance);
    AccountLoanDTO createIndividualLoanAccount(int individualId, int period, int amount);
    void deleteAccountByIban(String iban);


}
