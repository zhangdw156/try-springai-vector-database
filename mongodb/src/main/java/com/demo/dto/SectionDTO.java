package com.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class SectionDTO {

    private String label;
    private List<FieldDTO> fields;
}
