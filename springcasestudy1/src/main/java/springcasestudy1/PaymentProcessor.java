package springcasestudy1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {
	
	
    private PaymentService paymentService;

    @Autowired
    private TransactionLogger logger;

    @Autowired
    public PaymentProcessor(@Qualifier("upiPayment") PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void pay(double amount){
        logger.log("Processing started");
        paymentService.processPayment(amount);
    }
}
