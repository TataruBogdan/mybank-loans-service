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
                .stream()
                .map(accountLoan -> accountLoanMapper.accountToDTO(accountLoan))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AccountLoanDTO> getByIban(String iban) {
        return loanRepository.findById(iban)
                .map(accountCurrent -> accountLoanMapper.accountToDTO(accountCurrent));
    }

    @Override
    public List<AccountLoanDTO> getAllByIndividualId(int individualId) {
        return loanRepository.findByIndividualId(individualId)
                .stream()
                .map(accountLoan -> accountLoanMapper.accountToDTO(accountLoan))
                .collect(Collectors.toList());
    }

    @Override
    public AccountLoanDTO updateBalanceAccount(String iban, Double balance) {
        return null;
    }



    public AccountLoanDTO createIndividualLoanAccount(int individualId, int period, int amount) {

        AccountLoan accountLoan = new AccountLoan();

        accountLoan.setIban(UUID.randomUUID().toString());
        accountLoan.setLoanAmount(amount);
        accountLoan.setIndividualId(individualId);
        accountLoan.setPeriod(period);
        accountLoan.setInterestRate(interestRate);
        accountLoan.setStartDate(new Date());
        accountLoan.setLoanStatus(ACTIVE);
        accountLoan.setPrincipal(0.00); //TODO - CE ESTE Principal ??

        AccountLoan savedAccountLoan = loanRepository.save(accountLoan);
        AccountLoanDTO accountLoanDTO = accountLoanMapper.accountToDTO(savedAccountLoan);
        return accountLoanDTO;
    }

    @Override
    public void deleteAccountByIban(String iban) {
        loanRepository.deleteById(iban);
    }
}
