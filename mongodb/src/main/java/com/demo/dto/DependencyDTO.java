package com.demo.dto;

import lombok.Data;

@Data
public class DependencyDTO {

    private String from;
    private String to;
    private String description;
}
