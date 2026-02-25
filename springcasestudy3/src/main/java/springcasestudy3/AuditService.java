package springcasestudy3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AuditService {

    @PostConstruct
    public void start(){
        System.out.println("Audit Service Initialized");
    }

    public void audit(String msg){
        System.out.println("AUDIT: " + msg);
    }

    @PreDestroy
    public void stop(){
        System.out.println("Audit Service Destroyed");
    }
}