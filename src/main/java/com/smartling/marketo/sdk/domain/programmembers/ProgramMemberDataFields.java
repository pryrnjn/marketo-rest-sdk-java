package com.smartling.marketo.sdk.domain.programmembers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonSerialize(using = ProgramMemberDataFields.ProgramMemberDataFieldsSerializer.class)
public class ProgramMemberDataFields {

    private ImmutableMap<String, Object> fields;

    public ProgramMemberDataFields(Integer leadId, Map<String, Object> fields) {
        this.fields = ImmutableMap.<String, Object>builder()
                .put("leadId", leadId)
                .putAll(fields).build();
    }

    public static class ProgramMemberDataFieldsSerializer extends StdSerializer<ProgramMemberDataFields> {

        public ProgramMemberDataFieldsSerializer() {
            super(ProgramMemberDataFields.class);
        }

        protected ProgramMemberDataFieldsSerializer(
                Class<ProgramMemberDataFields> t) {
            super(t);
        }

        protected ProgramMemberDataFieldsSerializer(JavaType type) {
            super(type);
        }

        protected ProgramMemberDataFieldsSerializer(Class<?> t, boolean dummy) {
            super(t, dummy);
        }

        protected ProgramMemberDataFieldsSerializer(StdSerializer<?> src) {
            super(src);
        }

        @Override
        public void serialize(ProgramMemberDataFields programMemberDataFields,
                JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException {
            jsonGenerator.writeObject(programMemberDataFields.getFields());
        }
    }

}
