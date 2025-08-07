package com.demo.enums;

import com.alibaba.fastjson2.annotation.JSONType;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.writer.ObjectWriter;

import java.lang.reflect.Type;

@JSONType(serializer  = FieldType.FieldTypeSerializer.class, deserializer= FieldType.FieldTypeDeserializer.class)
public enum FieldType {
    TEXT("文本",0),
    NUMBER("数字",1),
    DATE("日期",2),
    SELECT("下拉框",3),
    EMAIL("邮箱",4);

    // 序列化器：将 FieldType 序列化为 code
    static class FieldTypeSerializer implements ObjectWriter<FieldType> {
        @Override
        public void write(com.alibaba.fastjson2.JSONWriter jsonWriter, Object object, Object fieldName, Type fieldType, long features) {
            if (object == null) {
                jsonWriter.writeNull();
                return;
            }
            FieldType ft = (FieldType) object;
            jsonWriter.writeInt32(ft.getCode());
        }
    }

    // 反序列化器：将 code 反序列化为 FieldType
    static class FieldTypeDeserializer implements ObjectReader<FieldType> {
        @Override
        public FieldType readObject(com.alibaba.fastjson2.JSONReader jsonReader, Type type, Object fieldName, long features) {
            int code = jsonReader.readInt32();
            for (FieldType ft : FieldType.values()) {
                if (ft.getCode() == code) {
                    return ft;
                }
            }
            return null;
        }
    }

    private final String label;

    private final Integer code;

    FieldType(String label, Integer code) {
        this.label = label;
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public Integer getCode() {
        return code;
    }

}
