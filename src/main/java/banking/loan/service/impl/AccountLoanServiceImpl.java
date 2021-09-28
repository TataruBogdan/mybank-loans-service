package banking.loan.service.impl;


import banking.loan.dao.LoanRepository;
import banking.loan.dto.AccountLoanDTO;
import banking.loan.model.AccountLoan;
import banking.loan.service.AccountLoanMapper;
import banking.loan.service.AccountLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static banking.loan.model.LoanStatus.ACTIVE;

@RequiredArgsConstructor
@Service
public class AccountLoanServiceImpl implements AccountLoanService {

    @Autowired
    private final LoanRepository loanRepository;


    private final AccountLoanMapper accountLoanMapper;

    @Override
    public List<AccountLoanDTO> getAll() {

        return loanRepository.findAll()
                .stream().map(accountLoan -> accountLoanMapper.accountToDTO(accountLoan))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AccountLoanDTO> getByIban(String iban) {
        return loanRepository.findById(iban)
                .map(accountCurrent -> accountLoanMapper.accountToDTO(accountCurrent));
    }

    @Override
    public List<AccountLoanDTO> getByIndividualId(int individualId) {
        List<AccountLoan> accountRepositoryByIndividual = loanRepository.findByIndividualId(individualId);
        List<AccountLoanDTO> accountLoanDTO = accountLoanMapper.toAccountCurrentDTO(accountRepositoryByIndividual);

        return accountLoanDTO;
    }

    @Override
    public AccountLoanDTO updateBalanceAccount(String iban, Double balance) {
        return null;
    }

    @Override
    public AccountLoanDTO creditBalanceAccount(String iban, Double balance) {
        return null;
    }

    @Override
    public AccountLoanDTO debitBalanceAccount(String iban, Double balance) {
        return null;
    }


    @Override
    public AccountLoanDTO createIndividualAccount(int individualId) {

        AccountLoan accountLoan = new AccountLoan();

        accountLoan.setIban(UUID.randomUUID().toString());
        accountLoan.setLoanAmount(0.00);
        accountLoan.setIndividualId(individualId);
        accountLoan.setPeriod("0"); // ??? period 1 year
        accountLoan.setInterestRate(0.00);
        accountLoan.setInterestReturn("0.01"); //? tratam ca un string
        accountLoan.setStartDate(new Date());
        accountLoan.setLoanStatus(ACTIVE);
        accountLoan.setPrincipal(0.00);


        return null;
    }

    @Override
    public void deleteAccountByIban(String iban) {
        loanRepository.deleteById(iban);
    }
}
