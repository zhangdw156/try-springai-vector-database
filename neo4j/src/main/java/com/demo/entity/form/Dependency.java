package com.demo.entity.form;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@RelationshipProperties
public class Dependency {
    @RelationshipId
    private Long id;

    @TargetNode
    private Field field;

    private String description;

    public Dependency(Field field, String description) {
        this.field = field;
        this.description = description;
    }

    public Dependency(Field field) {
        this.field = field;
    }
}
