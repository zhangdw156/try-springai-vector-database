package com.demo;

import com.demo.entity.form.Dependency;
import com.demo.entity.form.Field;
import com.demo.entity.form.Form;
import com.demo.entity.form.Template;
import com.demo.repository.TemplateRepository;
import com.demo.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
public class FormServiceTest {

    @Autowired
    private FormService formService;

    @Autowired
    private TemplateRepository templateRepository;

    @Test
    public void testCreate() {
//        Assert.notNull(formService, "formService is null");
//        log.info("测试formService的创建功能");
//        Template template = new Template();
//        template.setName("办公用品采购单模板");
//        template.setDescription("这是一份办公用品采购单模板");
//        template.setCreator("张三");
//        template.setCreateTime(LocalDateTime.now());
//
//        log.info("创建模板：{}", template);
//        formService.saveTemplate(template);
//        log.info("创建模板成功");
//
//        Field nameField = new Field();
//        nameField.setName("物品名称");
//        nameField.setDescription("描述物品的名称");
//
//        Field amountField = new Field();
//        amountField.setName("数量");
//        amountField.setDescription("描述物品的数量");
//
//        Field priceField = new Field();
//        priceField.setName("单价");
//        priceField.setDescription("描述物品的单价");
//
//        Field PSField = new Field();
//        PSField.setName("备注");
//        PSField.setDescription("备注");
//
//        log.info("创建字段：{}", nameField);
//        log.info("创建字段：{}", amountField);
//        log.info("创建字段：{}", priceField);
//        log.info("创建字段：{}", PSField);
//        template.addField(nameField);
//        template.addField(amountField);
//        template.addField(priceField);
//        template.addField(PSField);
//
//        log.info("添加单价对数量的依赖：数量越多，应该单价越低");
//        Dependency priceDependency = new Dependency(amountField, "数量越多，应该单价越低");
//
//        priceField.addDependency(priceDependency);
//        formService.saveField(priceField);
//
//        log.info("添加字段到模板");
//        template.addField(nameField);
//        template.addField(amountField);
//        template.addField(priceField);
//        template.addField(PSField);
//        formService.saveTemplate(template);
//
//        log.info("测试结束");

    }

    @Test
    public void testQuery() {
//        Assert.notNull(formService, "formService is null");
//        log.info("测试formService的查询功能");
//        String templateName = "办公用品采购单模板";
//        Form form = formService.findFormByName(templateName).getFirst();
//
//        Assert.notNull(form,  " form null");
//
//        log.info("查询模板：{}", form);
//        Template template = form.getTemplate();
//        Assert.notNull(template, "template is null");
//        log.info("表单模板：{}", template);
//
//        for (Field field : form.getFields()) {
//            log.info("查询字段：{}", field);
//            formService.findDependencyByName(field.getName())
//                    .stream()
//                    .map(Dependency::new)
//                    .forEach(field::addDependency);
//            log.info("表单字段: {}",field);
//        }
//        log.info("测试结束");
    }

}
