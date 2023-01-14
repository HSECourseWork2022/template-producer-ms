package dev.hse.template.kafka.serialization.utils;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonMapperUtils {

    private static JsonMapper cachedJsonMapper;

    public static JsonMapper getJsonMapper() {
        if (cachedJsonMapper == null) {
            cachedJsonMapper = new JsonMapper();
            cachedJsonMapper.registerModule(new JavaTimeModule());
        }
        return cachedJsonMapper;
    }
}
