package springcasestudy2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService {

    private DeliveryService deliveryService;

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    public void prepareFood(){
        System.out.println("Restaurant preparing food");
        deliveryService.deliver();
    }
}
