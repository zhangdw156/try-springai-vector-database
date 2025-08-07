package com.demo.entity.form;

import com.demo.enums.FieldType;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Node("表单字段")
public class Field {
    @Id
    @GeneratedValue
    private Long id;

    private String label;
    private FieldType type;
    private String description;
    private List<String> options;

    @Override
    public int hashCode() {
        return Objects.hash(id, label, type,description);
    }

    @Relationship(type = "依赖", direction = Relationship.Direction.OUTGOING)
    private List<Dependency> dependencyList;

    public void addDependency(Dependency dependency) {
        if(dependencyList == null){
            dependencyList=new ArrayList<>();
        }
        dependencyList.add(dependency);
    }
}
