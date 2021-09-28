package banking.loan.dao;

import banking.loan.model.AccountLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<AccountLoan, String> {

    List<AccountLoan> findByIndividualId(int individualId);
}
