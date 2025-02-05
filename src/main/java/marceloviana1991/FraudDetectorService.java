package marceloviana1991;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FraudDetectorService {

    public static void main(String[] args) {
        List<String> orderList = new LinkedList<>();
        try(var consumer = new ConsumerService(FraudDetectorService.class.getSimpleName())) {
            consumer.run(
                    Collections.singletonList("ECOMMERCE_NEW_ORDER"),
                    (topic, value) -> {
                        orderList.add(value);
                        System.out.println(orderList);
                    }
            );
        }
    }
}
