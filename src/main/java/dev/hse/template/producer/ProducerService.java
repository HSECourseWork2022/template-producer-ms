package dev.hse.template.producer;

import dev.hse.template.api.VendorService;
import dev.hse.template.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[template][producer][service]")
@Service
@RequiredArgsConstructor
public class ProducerService {

    private static final long INITIAL_DELAY_IN_MILLISECONDS = 1000;
    private final VendorService vendorService;
    private final KafkaProducerService kafkaProducerService;

    @Scheduled(initialDelay = INITIAL_DELAY_IN_MILLISECONDS, fixedDelayString = "${interval}")
    public void produceScheduled() {
        produce();
    }

    public void produce() {
        kafkaProducerService.send(vendorService.fetchData());
    }

}
