package dev.hse.template.kafka.serialization;

import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.hse.template.kafka.serialization.utils.JsonMapperUtils;
import dev.hse.template.pojo.TemplateRaw;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

@Slf4j(topic = "[preloader][template]")
public class RawModelDeserializer implements Deserializer<TemplateRaw> {

    private final JsonMapper mapper = JsonMapperUtils.getJsonMapper();

    @Override
    public TemplateRaw deserialize(String s, byte[] bytes) {
        try {
            return mapper.readValue(bytes, TemplateRaw.class);
        } catch (IOException e) {
            log.error("Error occurred while deserializing ", e);
            return null;
        }
    }
}
