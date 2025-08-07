package com.demo.service;

import com.demo.entity.form.Field;
import com.demo.entity.form.Form;
import com.demo.entity.form.Section;
import com.demo.entity.form.Template;
import com.demo.dto.TemplateDTO;

import java.util.List;


public interface FormService {

    public void saveTemplate(Template template);

    public void saveField(Field field);

    public void saveSection(Section section);

    public List<Form> findFormByName(String name);

    public List<Field> findDependencyByName(String name);

    public Boolean addTemplate(TemplateDTO templateDTO);
}