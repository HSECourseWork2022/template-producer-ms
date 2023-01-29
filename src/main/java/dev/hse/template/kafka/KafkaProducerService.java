package dev.hse.template.kafka;

import dev.hse.template.pojo.TemplateRaw;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[template][producer][kafka-producer]")
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${producer.source}.${producer.subtheme}.producers.outcome")
    private String outputTopic;
    private final KafkaTemplate<String, TemplateRaw> kafkaTemplate;

    public void send(TemplateRaw templateRaw) {
        log.info("Sending to '{}' topic", outputTopic);
        kafkaTemplate.send(outputTopic, templateRaw);
    }
}
