package springcasestudy2;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DeliveryService {

    @PostConstruct
    public void start(){
        System.out.println("Delivery Service Ready");
    }

    public void deliver(){
        System.out.println("Food delivered");
    }

    @PreDestroy
    public void stop(){
        System.out.println("Delivery Service Closed");
    }
}
