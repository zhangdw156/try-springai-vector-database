package com.demo.repository;

import com.demo.entity.form.Field;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface FieldRepository extends Neo4jRepository<Field, Long> {
    @Query("MATCH (:`字段`{name:$name})-[:`依赖字段`]->(d:`字段`) RETURN d")
    List<Field> findByName(String name);
}
