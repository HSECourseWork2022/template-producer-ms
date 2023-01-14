package dev.hse.template.service;

import dev.hse.template.kafka.KafkaProducerService;
import dev.hse.template.pojo.TemplateMatched;
import dev.hse.template.pojo.TemplateRaw;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j(topic = "[preloader][template]")
@Service
@RequiredArgsConstructor
public class PreloadProcessingService {

    private final KafkaProducerService kafkaProducerService;

    public void process(TemplateRaw templateRaw) {
        TemplateMatched templateMatched = new TemplateMatched();
        templateMatched.setMatchedId(420L);
        templateMatched.setSourceId(templateRaw.getSourceId());
        templateMatched.setPrice(12.23);
        templateMatched.setTimestamp(LocalDateTime.now());

        kafkaProducerService.send(templateMatched);
    }
}
