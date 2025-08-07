package com.demo.entity.form;

import lombok.Data;

import java.util.List;

@Data
public class Form {
    private Template template;
    private List<Field> fields;
}
