package com.demo.repository;

import com.demo.entity.form.Form;
import com.demo.entity.form.Template;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import java.util.List;

public interface TemplateRepository extends Neo4jRepository<Template, Long> {

    @Query("MATCH (t:`表单模板`{name:$name})-[:`包含`]->(f:`字段`) RETURN t as template,collect(f) as fields")
    List<Form> findFormByName(String name);

}