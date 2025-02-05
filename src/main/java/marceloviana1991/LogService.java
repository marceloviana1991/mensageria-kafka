package marceloviana1991;

import java.util.List;

public class LogService {

    public static void main(String[] args) {
        try(var consumer = new ConsumerService(LogService.class.getSimpleName())) {
            consumer.run(
                    List.of("ECOMMERCE_SEND_EMAIL", "ECOMMERCE_NEW_ORDER"),
                    (topic, value) -> {
                        System.out.println(topic + " - " + value);
                    }
            );
        }
    }
}
