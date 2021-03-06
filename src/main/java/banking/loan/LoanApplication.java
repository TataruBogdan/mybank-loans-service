package banking.loan;


import banking.loan.dao.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO
//Caused by: org.hibernate.type.SerializationException: could not deserialize


@SpringBootApplication
//@EnableAutoConfiguration
public class LoanApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
    }

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void run(String... args) throws Exception {
//
//        logger.info("Insert loan -> {}", loanRepository.save(new AccountLoan("Loan123", 10000.00, 10001, Period.ofYears(5),
//                0.50, "1.00", new Date(), LoanStatus.ACTIVE, 0.10)));
//
//        logger.info("All loans -> {}", loanRepository.findAll());
//
    }
}
