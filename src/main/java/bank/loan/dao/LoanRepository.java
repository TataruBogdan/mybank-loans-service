package bank.loan.dao;

import bank.loan.model.AccountLoan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanRepository extends JpaRepository<AccountLoan, String> {
}
