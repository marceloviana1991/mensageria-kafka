package marceloviana1991;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmailService {

    public static void main(String[] args) {
        List<String> emailList = new LinkedList<>();
        ConsumerService.run(
                Collections.singletonList("ECOMMERCE_SEND_EMAIL"),
                EmailService.class.getSimpleName(),
                (value) -> {
                    emailList.add(value);
                }
        );
    }
}
