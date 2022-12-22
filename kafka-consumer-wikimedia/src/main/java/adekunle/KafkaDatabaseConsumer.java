package adekunle;


import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaDatabaseConsumer {

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "my-group")
    public void consumer(String message) {
        log.info("Event message received -> {}",message);

    }
}
