package springcasestudy1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentProcessor processor = ctx.getBean(PaymentProcessor.class);

        processor.pay(500);

        ctx.close();
    }
}