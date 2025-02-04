package marceloviana1991;

import java.util.List;

public class LogService {

    public static void main(String[] args) {
        ConsumerService.run(
                List.of("ECOMMERCE_SEND_EMAIL", "ECOMMERCE_NEW_ORDER"),
                LogService.class.getSimpleName(),
                (value) -> {}
        );
    }
}
