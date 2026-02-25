package springcasestudy3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IncomeValidator implements LoanValidator {

    @Override
    public void validateLoan(double amount){
        System.out.println("Income validated for loan: " + amount);
    }
}