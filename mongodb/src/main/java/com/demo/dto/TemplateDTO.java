package com.demo.dto;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "forms")
public class TemplateDTO {
    private String creator;
    private String templateName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String description;
    List<SectionDTO> sections;
    List<DependencyDTO> dependencies;
}