package marceloviana1991;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerService {

    public static void run(String topic, String groupId, GetValue getValue) {
        var consumer = new KafkaConsumer<String, String>(properties(groupId));
        consumer.subscribe(Collections.singletonList(topic));
        while(true) {
            var records = consumer.poll(Duration.ofMillis(100));
            if(!records.isEmpty()) {
                System.out.println("Encontrei " + records.count() + " registros");
                for(var record: records) {
                    System.out.println("---------------------");
                    System.out.println("Processing new order, checking for fraud");
                    System.out.println(record.key());
                    System.out.println(record.value());
                    System.out.println(record.partition());
                    System.out.println(record.offset());
                    getValue.get(record.value());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // ignoring
                        e.printStackTrace();
                    }
                    System.out.println("Order processed");
                }
            }
        }
    }

    private static Properties properties(String groupId) {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return properties;
    }
}
