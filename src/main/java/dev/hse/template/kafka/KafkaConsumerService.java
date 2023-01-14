package dev.hse.template.kafka;

import dev.hse.template.pojo.TemplateRaw;
import dev.hse.template.service.PreloadProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[preloader][template]")
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final PreloadProcessingService preloadProcessingService;

    @KafkaListener(topics = "${filtered.topic}")
    public void consume(TemplateRaw templateRaw) {
        log.info("Got from kafka: {} ", templateRaw);
        preloadProcessingService.process(templateRaw);
    }
}
