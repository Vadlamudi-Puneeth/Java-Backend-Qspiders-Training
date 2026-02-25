package springcasestudy3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoanService {

    private LoanValidator validator;
    private AuditService auditService;

    // constructor injection with qualifier
    @Autowired
    public LoanService(@Qualifier("incomeValidator") LoanValidator validator){
        this.validator = validator;
    }

    // setter injection
    @Autowired
    public void setAuditService(AuditService auditService){
        this.auditService = auditService;
    }

    public void applyLoan(double amount){
        validator.validateLoan(amount);
        auditService.audit("Loan processed: " + amount);
    }
}
