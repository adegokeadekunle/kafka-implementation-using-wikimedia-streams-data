package com.adekunle;

import com.adekunle.eventHandler.WikiMediaChangesHandler;
import com.adekunle.service.WikimediaChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class);
    }

    @Autowired
    private WikimediaChangesProducer changesProducer;

    @Override
    public void run(String... args) throws Exception {
        changesProducer.sendMessage();
    }
}
