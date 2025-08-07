package com.demo;

import com.demo.dto.TemplateDTO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class TemplateDTOTest {

    private final Gson gson = new Gson();
    @Test
    public void test() {
//        TemplateDTO templateDTO = new TemplateDTO();
//        templateDTO.setUserName("张三");
//        templateDTO.setTemplateName("办公用品采购单");
//        templateDTO.setCreateTime(LocalDate.now().toString());
//        templateDTO.setDescription("这是一份办公用品采购单");
//
//        Map<String, String> fields = new HashMap<>();
//        fields.put("物品名称", "字符串");
//        fields.put("数量", "正整数");
//        fields.put("采购原因", "字符串");
//        templateDTO.setFields(fields);
//
//        Map<String, List<String>> dependencies = new HashMap<>();
//        dependencies.put("单价", Arrays.asList("数量"));
//
//        templateDTO.setDependencies(dependencies);
//        log.info("构造好的FormDTO对象：{}", templateDTO);
//        String json = gson.toJson(templateDTO);
//        log.info("转成json字符串：{}",json);
    }

}