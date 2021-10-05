package banking.loan.service;


import banking.commons.dto.AccountLoanDTO;
import banking.loan.model.AccountLoan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountLoanMapper {

    AccountLoanDTO accountToDTO(AccountLoan accountLoan);

    List<AccountLoanDTO> toAccountCurrentDTO(List<AccountLoan> accountCurrentList);

    AccountLoan toAccountCurrent(AccountLoanDTO accountCurrentDTO);


}
