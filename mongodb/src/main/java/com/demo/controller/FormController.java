package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.dto.TemplateDTO;
import com.demo.service.FormService;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/llm/form")
@Tag(name = "表单管理",description = "表单管理接口")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/forms")
    @Operation(summary = "新增表单",description = "新增表单数据")
    public void add(@RequestBody String json) {
        log.info("Add form data");
        TemplateDTO form = JSON.parseObject(json, TemplateDTO.class);
        log.info(form.toString());
        formService.save(form);
        log.info("Form data added successfully");
    }

}
