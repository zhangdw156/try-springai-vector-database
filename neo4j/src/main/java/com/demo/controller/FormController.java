package com.demo.controller;


import com.alibaba.fastjson2.JSON;
import com.demo.dto.TemplateDTO;
import com.demo.service.FormService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/llm/form")
public class FormController {

    public final Gson gson = new Gson();

    @Autowired
    private FormService formService;

    @PostMapping("/templates")
    public void createForm(@RequestBody String json) {
        log.info("Creating form with json: {}", json);
        TemplateDTO templateDTO= JSON.parseObject(json, TemplateDTO.class);
        log.info("Form created with details: {}", templateDTO);
        log.info("验证枚举类: {}", templateDTO.getSections().get(0).getFields().get(0).getType().getLabel());
        if(formService.addTemplate(templateDTO)){
            log.info("Form created successfully");
        }else{
            log.error("Error while creating form");
        }
    }

}