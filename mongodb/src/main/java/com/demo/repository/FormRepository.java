package com.demo.repository;

import com.demo.dto.TemplateDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends MongoRepository<TemplateDTO, String> {
}
