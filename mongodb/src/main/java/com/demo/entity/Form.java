package com.demo.entity;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "forms")
public class Form {
    @Id
    private String id;  // MongoDB 默认使用 ObjectId，也可以用 String
    private String userName;
    private String templateName;
    private String createTime;
    private String description;
    private Map<String, String> fields;
    private Map<String, List<String>> dependencies;
}
