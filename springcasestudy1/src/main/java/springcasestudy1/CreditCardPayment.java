package springcasestudy1;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCardPayment implements PaymentService {

    private final TransactionLogger logger;

    public CreditCardPayment(TransactionLogger logger){
        this.logger = logger;
    }

    @Override
    public void processPayment(double amount){
        logger.log("Credit card payment: " + amount);
        System.out.println("Paid via Credit Card");
    }
}
