package com.demo.service;

import com.demo.dto.TemplateDTO;
import com.demo.entity.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.repository.FormRepository;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public void save(TemplateDTO form) {
        formRepository.save(form);
    }
}
