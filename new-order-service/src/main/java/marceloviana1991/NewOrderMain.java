package marceloviana1991;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try(var producer = new ProducerService()) {

            var userId = UUID.randomUUID().toString();

            var order = new Order(
                    userId,
                    UUID.randomUUID().toString(),
                    new BigDecimal("10")
                    );

            producer.send(
                    "ECOMMERCE_NEW_ORDER",
                    order.getUserId(),
                    order
            );

            var email = new Email(
                    UUID.randomUUID().toString(),
                    "email@email.com",
                    "Thank you for your order! We are processing your order!",
                    userId
            );

            producer.send(
                    "ECOMMERCE_SEND_EMAIL",
                    email.getUserId(),
                    email
            );
        }
    }
}