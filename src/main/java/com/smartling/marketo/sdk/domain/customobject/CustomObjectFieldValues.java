package com.smartling.marketo.sdk.domain.customobject;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;

@Data
@AllArgsConstructor
@JsonSerialize(using = CustomObjectFieldValues.CustomObjectFieldsSerializer.class)
public class CustomObjectFieldValues {

    private ImmutableMap<String, Object> fields;

    public static class CustomObjectFieldsSerializer extends StdSerializer<CustomObjectFieldValues> {

        public CustomObjectFieldsSerializer() {
            super(CustomObjectFieldValues.class);
        }

        protected CustomObjectFieldsSerializer(
                Class<CustomObjectFieldValues> t) {
            super(t);
        }

        protected CustomObjectFieldsSerializer(JavaType type) {
            super(type);
        }

        protected CustomObjectFieldsSerializer(Class<?> t, boolean dummy) {
            super(t, dummy);
        }

        protected CustomObjectFieldsSerializer(StdSerializer<?> src) {
            super(src);
        }

        @Override
        public void serialize(CustomObjectFieldValues customObjectFieldValues,
                JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException {
            jsonGenerator.writeObject(customObjectFieldValues.getFields());
        }
    }

}
