package com.demo;

import com.demo.entity.WifeRelation;
import com.demo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.demo.repository.PersonRepository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@SpringBootTest
public class PersonTest {
    @Autowired
    private PersonRepository personRepository;

    List<Long> ids = new ArrayList<>();

    @Test
    public void testRelationship() {
        Person person1 = new Person();
        Person person2 = new Person();

        person1.setName("小明2");
        person2.setName("小红2");

        personRepository.save(person1);
        personRepository.save(person2);

        ids.add(person1.getId());
        ids.add(person2.getId());
        ids.forEach(id->log.info("id: {}", id));

        log.info("Person1: {}", person1);
        log.info("Person2: {}", person2);

        person1.addFriend(person2);
        personRepository.save(person1);
        log.info("Person1: {}", person1);
        Assert.isTrue(!person1.getFriends().isEmpty(), "关系保存失败");
    }

    @Test
    public void testLove() {
        log.info("测试情侣关系");
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        person1.setName("杨过");
        person2.setName("小龙女");
        person3.setName("尹志平");
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);

        ids.add(person1.getId());
        ids.add(person2.getId());
        ids.add(person3.getId());
        ids.forEach(id->log.info("id: {}", id));

        WifeRelation relation = new WifeRelation(person2, new Date(), "活死人墓");
        person1.addWife(relation);
        person1.addLike(person2);
        personRepository.save(person1);
        person2.addLike(person1);
        personRepository.save(person2);
        person3.addLike(person2);
        person3.addDisLike(person1);
        personRepository.save(person3);
    }

//    @AfterEach
//    public void removeIds(){
//        log.info("删除测试数据");
//        ids.forEach(id -> personRepository.deleteById(id));
//        log.info("删除完成");
//    }
}
