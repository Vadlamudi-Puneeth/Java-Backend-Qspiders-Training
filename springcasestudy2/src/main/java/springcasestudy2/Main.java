package springcasestudy2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(FoodAppConfig.class);

        OrderService order = ctx.getBean(OrderService.class);

        order.placeOrder();

        ctx.close();
    }
}