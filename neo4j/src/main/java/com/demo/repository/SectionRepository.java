package com.demo.repository;

import com.demo.entity.form.Field;
import com.demo.entity.form.Section;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends Neo4jRepository<Section, Long> {
}
