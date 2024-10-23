package com.apimarket.market.adapters.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.util.Objects;

public class ObjectConverted implements AttributeConverter<Object, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object o) {
        try {
            if(Objects.nonNull(o)) {
                return objectMapper.writeValueAsString(o);
            } else {
                return null;
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Object convertToEntityAttribute(String s) {
        try {
            if(Objects.nonNull(s)) {
                return objectMapper.readValue(s, Object.class);
            } else {
                return null;
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}