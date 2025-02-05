package marceloviana1991;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try(var producer = new ProducerService()) {

            var order = new Order(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    new BigDecimal("10")
                    );

            producer.send(
                    "ECOMMERCE_NEW_ORDER",
                    order.getOrderId(),
                    order
            );

            var email = new Email(
                    UUID.randomUUID().toString(),
                    "email@email.com",
                    "Thank you for your order! We are processing your order!"
            );

            producer.send(
                    "ECOMMERCE_SEND_EMAIL",
                    email.getEmailId(),
                    email
            );
        }
    }
}