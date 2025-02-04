package marceloviana1991;

import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ProducerService.send(
                "ECOMMERCE_NEW_ORDER",
                "132123,67523,7894589745",
                "132123,67523,7894589745"
        );

        ProducerService.send(
                "ECOMMERCE_SEND_EMAIL",
                "Thank you for your order! We are processing your order!",
                "Thank you for your order! We are processing your order!"
        );
    }
}