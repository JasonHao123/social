package org.springframework.social.http.converter;

import java.lang.reflect.Type;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class MappingJackson2HttpMessageConverterFasterXml extends MappingJackson2HttpMessageConverter {

    @Override
    public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
        if(type.equals(org.codehaus.jackson.JsonNode.class)) return false;

        if (type instanceof Class) {
            Class clazz = (Class) type;
            MappingJacksonType annotation = (MappingJacksonType) clazz.getAnnotation(MappingJacksonType.class);
            if (annotation != null) {
                if (JacksonConverterTypes.Jackson == annotation.convertType())
                    return false;
            }
        }
        return super.canRead(type, contextClass, mediaType);
    }

}
