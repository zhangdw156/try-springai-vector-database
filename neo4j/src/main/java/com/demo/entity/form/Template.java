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
@Node("表单模板")
public class Template {
    @Id
    @GeneratedValue
    private Long id;

    private String label;
    private String description;
    private String creator;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Relationship(type = "包含", direction = Relationship.Direction.OUTGOING)
    private List<Section> sectionList;

    public void addSection(Section section) {
        if(sectionList == null){
            sectionList = new ArrayList<>();
        }
        sectionList.add(section);
    }
}
