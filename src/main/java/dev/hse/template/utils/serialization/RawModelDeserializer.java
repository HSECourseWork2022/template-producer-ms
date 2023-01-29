package dev.hse.template.utils.serialization;

import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.hse.template.pojo.TemplateRaw;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j(topic = "[producer][template]")
public class RawModelDeserializer {

    private final JsonMapper mapper = JsonMapperUtils.getJsonMapper();

    public TemplateRaw deserialize(byte[] bytes) {
        try {
            return mapper.readValue(bytes, TemplateRaw.class);
        } catch (IOException e) {
            log.error("Error occurred while deserializing ", e);
            return null;
        }
    }
}