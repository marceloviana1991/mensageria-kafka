package marceloviana1991;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FraudDetectorService {

    public static void main(String[] args) {
        List<String> orderList = new LinkedList<>();
        ConsumerService.run(
                Collections.singletonList("ECOMMERCE_NEW_ORDER"),
                FraudDetectorService.class.getSimpleName(),
                (value) -> {
                    orderList.add(value);
                }
        );
    }
}
