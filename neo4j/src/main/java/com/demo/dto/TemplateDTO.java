package com.demo.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class TemplateDTO {
    private String creator;
    private String templateName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String description;
    List<SectionDTO> sections;
    List<DependencyDTO> dependencies;
}