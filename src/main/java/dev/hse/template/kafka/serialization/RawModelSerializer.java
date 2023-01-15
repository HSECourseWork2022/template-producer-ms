package dev.hse.template.kafka.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.hse.template.kafka.serialization.utils.JsonMapperUtils;
import dev.hse.template.pojo.TemplateRaw;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j(topic = "[preloader][template]")
public class RawModelSerializer implements Serializer<TemplateRaw> {

    private final JsonMapper mapper = JsonMapperUtils.getJsonMapper();

    @Override
    public byte[] serialize(String s, TemplateRaw templateRaw) {
        try {
            return mapper.writeValueAsBytes(templateRaw);
        } catch (JsonProcessingException e) {
            log.error("Error occurred while serializing ", e);
            throw new RuntimeException(e);
        }
    }
}
