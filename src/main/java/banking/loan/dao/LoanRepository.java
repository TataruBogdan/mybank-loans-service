package banking.loan.dao;

import banking.loan.model.AccountLoan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanRepository extends JpaRepository<AccountLoan, String> {
}
