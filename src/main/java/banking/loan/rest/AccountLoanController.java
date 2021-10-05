package banking.loan.rest;


import banking.commons.dto.IndividualDTO;
import banking.commons.dto.AccountLoanDTO;
import banking.loan.dto.ArgsDTO;
import banking.loan.service.AccountLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/accounts-loan")
public class AccountLoanController {

    @Autowired
    private AccountLoanService accountLoanService;

    @Autowired
    private IndividualRestClient individualRestClient;

    @GetMapping("/")
    public ResponseEntity<List<AccountLoanDTO>> retrieveAllAccountLoan(){

        List<AccountLoanDTO> allAccountsLoan = accountLoanService.getAll();

        if (allAccountsLoan.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<AccountLoanDTO> newAccountLoan= new LinkedList<>();
        for (AccountLoanDTO accountLoanDTO:allAccountsLoan ) {
            IndividualDTO individualById = individualRestClient.getIndividualById(accountLoanDTO.getIndividualId());
            accountLoanDTO.setIndividualDTO(individualById);
            newAccountLoan.add(accountLoanDTO);
        }
        return ResponseEntity.ok(newAccountLoan);
    }

    @GetMapping("/{iban}")
    public ResponseEntity<AccountLoanDTO> retrieveAccountLoanByIban(@PathVariable("iban") String iban){

        Optional<AccountLoanDTO> accountLoanDTO = accountLoanService.getByIban(iban);

        if (accountLoanDTO.isPresent()){
            IndividualDTO individualById = individualRestClient.getIndividualById(accountLoanDTO.get().getIndividualId());
            accountLoanDTO.get().setIndividualDTO(individualById);
            return ResponseEntity.ok(accountLoanDTO.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/delete/{iban}")
    public void deleteAccountLoan(@PathVariable("iban") String iban){
        accountLoanService.deleteAccountByIban(iban);
    }


    @GetMapping("/individual/{individualId}")
    public ResponseEntity<List<AccountLoanDTO>> retrieveAccountLoanById(@PathVariable("individualId") int individualId){

        IndividualDTO individualById = individualRestClient.getIndividualById(individualId);
        List<AccountLoanDTO> allAccountsLoanByIndividualId = accountLoanService.getAllByIndividualId(individualId);

        if (allAccountsLoanByIndividualId.isEmpty()){
            ResponseEntity.notFound().build();
        }

        for (AccountLoanDTO accountsLoan: allAccountsLoanByIndividualId) {
            accountsLoan.setIndividualDTO(individualById);
        }
        return ResponseEntity.ok(allAccountsLoanByIndividualId);

    }

    @PostMapping(value = "/create/individual/{individualId}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountLoanDTO> createAccountLoanForIndividual(@PathVariable("individualId") int individualId,@RequestBody ArgsDTO argsDTO){

        AccountLoanDTO individualLoanAccount = accountLoanService.createIndividualLoanAccount(individualId, argsDTO.getPeriod(), argsDTO.getAmount());

        IndividualDTO individualById = individualRestClient.getIndividualById(individualLoanAccount.getIndividualId());

        individualLoanAccount.setIndividualDTO(individualById);
        return ResponseEntity.ok(individualLoanAccount);

    }

//    @PatchMapping("credit/{iban}")
//    public  ResponseEntity<AccountLoanDTO> creditAccountLoanIban(@PathVariable("iban") String iban, @RequestBody CreditAmountLoanDTO amount){
//
//
//        Optional<AccountLoanDTO> accountLoanByIban = accountLoanService.getByIban(iban);
//
//        IndividualDTO individualById = individualRestClient.getIndividualById(accountLoanByIban.get().getIndividualId());
//
//        AccountLoanDTO creditAccountLoanDTO = accountLoanService.creditAccountLoan(iban, amount.getAmount());
//        creditAccountLoanDTO.setIndividualDTO(individualById);
//
//        return ResponseEntity.ok(creditAccountLoanDTO);
//
//
//    }



}
