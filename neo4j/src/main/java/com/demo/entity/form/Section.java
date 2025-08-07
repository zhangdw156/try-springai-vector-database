package com.demo.entity.form;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Node("表单章节")
public class Section {

    @Id
    @GeneratedValue
    private Long id;

    private String label;

    @Relationship(type = "包含", direction = Relationship.Direction.OUTGOING)
    private List<Field> fieldList;

    public void addField(Field field) {
        if(fieldList == null){
            fieldList = new ArrayList<>();
        }
        fieldList.add(field);
    }


}
