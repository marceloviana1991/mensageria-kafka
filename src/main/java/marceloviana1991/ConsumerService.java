package marceloviana1991;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ConsumerService<T> implements Closeable {
    private final KafkaConsumer<String, String> consumer;

    public ConsumerService(String groupId) {
        this.consumer = new KafkaConsumer<>(properties(groupId));
    }

    public void run(List<String> topic, GetValue<T> getValue, Class<T> tClass) {
        consumer.subscribe(topic);
        while(true) {
            var records = consumer.poll(Duration.ofMillis(100));
            if(!records.isEmpty()) {
                for(var record: records) {
                    if (!tClass.equals(String.class)) {
                        Gson gson = new Gson();
                        var value = gson.fromJson(record.value(), tClass);
                        getValue.get(record.topic(), value);
                    } else {
                        getValue.get(record.topic(), (T) record.value());
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // ignoring
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private Properties properties(String groupId) {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return properties;
    }

    @Override
    public void close() {
        consumer.close();
    }
}
