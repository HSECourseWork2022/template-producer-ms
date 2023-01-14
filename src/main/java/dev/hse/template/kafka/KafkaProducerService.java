package dev.hse.template.kafka;

import dev.hse.template.pojo.TemplateMatched;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[preloader][template]")
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${loader.topic}")
    private String loaderTopic;
    private final KafkaTemplate<String, TemplateMatched> kafkaTemplate;

    public void send(TemplateMatched templateMatched) {
        log.info("Sending to '{}' topic", loaderTopic);
        kafkaTemplate.send(loaderTopic, templateMatched);
    }
}
