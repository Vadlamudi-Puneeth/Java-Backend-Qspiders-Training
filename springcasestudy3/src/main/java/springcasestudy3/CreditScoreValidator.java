package springcasestudy3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditScoreValidator implements LoanValidator {

    @Override
    public void validateLoan(double amount){
        System.out.println("Credit score validated for loan: " + amount);
    }
}