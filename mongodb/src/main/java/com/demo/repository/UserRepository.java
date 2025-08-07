package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // 自定义查询方法（Spring Data 自动解析方法名生成查询）
    List<User> findByName(String name);
    List<User> findByAgeGreaterThan(int age);
}
