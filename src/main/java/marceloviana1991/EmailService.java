package marceloviana1991;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmailService {

    public static void main(String[] args) {
        List<Email> emailList = new LinkedList<>();
        try(var consumer = new ConsumerService<Email>(EmailService.class.getSimpleName())) {
            consumer.run(
                    Collections.singletonList("ECOMMERCE_SEND_EMAIL"),
                    (topic, value) -> {
                        emailList.add(value);
                        System.out.println(emailList);
                    },
                    Email.class
            );
        }
    }
}
