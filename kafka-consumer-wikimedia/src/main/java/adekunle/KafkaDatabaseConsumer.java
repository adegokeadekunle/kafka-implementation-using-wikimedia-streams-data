package adekunle;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {

    private final WikimediaDataEntityRepository wikiRepo;

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "my-group")
    public void consumer(String eventMessage) {
        log.info("Event message received -> {}",eventMessage);

        WikimediaDataEntity wikiEntity = new WikimediaDataEntity();
        wikiEntity.setWikiEventData(eventMessage);
        wikiRepo.save(wikiEntity);

    }
}
