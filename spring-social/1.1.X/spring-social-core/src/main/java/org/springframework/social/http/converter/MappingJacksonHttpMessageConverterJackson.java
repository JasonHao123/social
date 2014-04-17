package org.springframework.social.http.converter;

import java.lang.reflect.Type;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

public class MappingJacksonHttpMessageConverterJackson extends MappingJacksonHttpMessageConverter {
    @Override
    public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
        if(type.equals(com.fasterxml.jackson.databind.JsonNode.class)) return false;
        if (type instanceof Class) {
            Class clazz = (Class) type;

            MappingJacksonType annotation = (MappingJacksonType) clazz.getAnnotation(MappingJacksonType.class);
            if (annotation != null) {
                if (JacksonConverterTypes.Fasterxml == annotation.convertType())
                    return false;
            }

        }
        return super.canRead(type, contextClass, mediaType);
    }

}
