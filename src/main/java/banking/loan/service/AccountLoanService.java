package banking.loan.service;

import banking.loan.dto.AccountLoanDTO;

import java.util.List;
import java.util.Optional;

public interface AccountLoanService {


    List<AccountLoanDTO> getAll();
    Optional<AccountLoanDTO> getByIban(String iban);
    List<AccountLoanDTO> getByIndividualId(int individualId);
    AccountLoanDTO updateBalanceAccount(String iban, Double balance);
    AccountLoanDTO creditBalanceAccount(String iban, Double balance);
    AccountLoanDTO debitBalanceAccount(String iban, Double balance);
    AccountLoanDTO createIndividualAccount(int individualId);
    void deleteAccountByIban(String iban);


}
