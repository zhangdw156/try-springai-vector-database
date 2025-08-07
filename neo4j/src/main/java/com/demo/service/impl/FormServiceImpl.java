package com.demo.service.impl;

import com.demo.dto.DependencyDTO;
import com.demo.dto.FieldDTO;
import com.demo.dto.SectionDTO;
import com.demo.dto.TemplateDTO;
import com.demo.entity.form.*;
import com.demo.repository.FieldRepository;
import com.demo.repository.SectionRepository;
import com.demo.repository.TemplateRepository;
import com.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public void saveTemplate(Template template) {
        templateRepository.save(template);
    }

    @Override
    public void saveField(Field field) {
        fieldRepository.save(field);
    }

    @Override
    public void saveSection(Section section) {
        sectionRepository.save(section);
    }

    @Override
    public List<Form> findFormByName(String name) {
        return templateRepository.findFormByName(name);
    }

    @Override
    public List<Field> findDependencyByName(String name) {
        return fieldRepository.findByName(name);
    }

    @Override
    public Boolean addTemplate(TemplateDTO templateDTO) {
        Template template = new Template();
        template.setLabel(templateDTO.getTemplateName());
        template.setCreator(templateDTO.getCreator());
        template.setDescription(templateDTO.getDescription());
        template.setCreateTime(templateDTO.getCreateTime());
        template.setUpdateTime(templateDTO.getUpdateTime());

        saveTemplate(template);

        List<Section> sectionList = new ArrayList<>();

        Map<String, Field> fieldMap = new HashMap<>();

        for (SectionDTO sectionDTO : templateDTO.getSections()) {

            List<Field> fieldList = new ArrayList<>();

            for (FieldDTO fieldDTO : sectionDTO.getFields()) {
                Field field = new Field();
                field.setLabel(fieldDTO.getLabel());
                field.setType(fieldDTO.getType());
                field.setDescription(fieldDTO.getDescription());
                field.setOptions(fieldDTO.getOptions());
                saveField(field);
                fieldList.add(field);
                fieldMap.put(field.getLabel(), field);
            }

            Section section = new Section();
            section.setLabel(sectionDTO.getLabel());
            section.setFieldList(fieldList);
            saveSection(section);
            sectionList.add(section);
        }

        template.setSectionList(sectionList);
        saveTemplate(template);

        for (DependencyDTO dependencyDTO : templateDTO.getDependencies()) {
            Field from= fieldMap.get(dependencyDTO.getFrom());
            Field to = fieldMap.get(dependencyDTO.getTo());
            String description = dependencyDTO.getDescription();
            Dependency dependency = new Dependency(to,description);
            from.addDependency(dependency);
            saveField(from);
        }

        return true;
    }
}
