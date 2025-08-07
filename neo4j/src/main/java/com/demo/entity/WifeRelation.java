package com.demo.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.Date;
import java.util.Objects;

@Data
@RelationshipProperties()
public class WifeRelation {
    @RelationshipId
    private Long id;

    @TargetNode
    private Person person;

    private Date merryDate;

    private String merryCity;

    public WifeRelation(Person person, Date merryDate, String merryCity) {
        this.person = person;
        this.merryDate = merryDate;
        this.merryCity = merryCity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, merryDate, merryCity);
    }


}
