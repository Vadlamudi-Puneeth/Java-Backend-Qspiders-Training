package springcasestudy3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(BankAppConfig.class);

        LoanService service = ctx.getBean(LoanService.class);

        service.applyLoan(100000);

        ctx.close();
    }
}