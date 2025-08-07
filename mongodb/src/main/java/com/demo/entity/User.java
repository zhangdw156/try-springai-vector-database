package com.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;  // MongoDB 默认使用 ObjectId，也可以用 String
    private String name;
    private int age;
    private String email;

    // 构造函数、Getter 和 Setter
    public User() {}

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

}
