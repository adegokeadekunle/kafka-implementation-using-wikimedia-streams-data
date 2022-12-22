package com.adekunle.service;

import com.adekunle.eventHandler.WikiMediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaChangesProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        String topic ="wikimedia_recentchange";
        EventHandler eventHandler = new WikiMediaChangesHandler(kafkaTemplate,topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder eventSource = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource source = eventSource.build();
        source.start();
        TimeUnit.MINUTES.sleep(10);
    }
}
