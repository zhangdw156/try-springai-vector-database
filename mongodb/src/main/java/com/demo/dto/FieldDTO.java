package com.demo.dto;

import com.demo.enums.FieldType;
import lombok.Data;

import java.util.List;

@Data
public class FieldDTO {

    private String label;
    private FieldType type;
    private String description;
    private List<String> options;
    private String value;

}
