package com.demo.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Node("Person")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Relationship(type = "朋友", direction = Relationship.Direction.OUTGOING)
    private List<Person> friends;

    @Relationship(type="妻子",direction = Relationship.Direction.OUTGOING)
    private List<WifeRelation> wifeRelations;

    @Relationship(type="喜欢",direction = Relationship.Direction.OUTGOING)
    private List<Person> likes;

    @Relationship(type="讨厌",direction = Relationship.Direction.OUTGOING)
    private List<Person> dislikes;

    public void addFriend(Person friend){
        if(this.friends == null){
            this.friends = new ArrayList<>();
        }
        this.friends.add(friend);
    }

    public void addLike(Person friend){
        if(this.likes == null){
            this.likes = new ArrayList<>();
        }
        this.likes.add(friend);
    }

    public void addDisLike(Person friend){
        if(this.dislikes == null){
            this.dislikes = new ArrayList<>();
        }
        this.dislikes.add(friend);
    }

    public void addWife(WifeRelation lover){
        if(this.wifeRelations == null){
            this.wifeRelations = new ArrayList<>();
        }
        this.wifeRelations.add(lover);
    }
}
