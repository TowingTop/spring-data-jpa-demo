package com.example.demo.dao;

import com.example.demo.domain.TagType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagTypeRepository extends JpaRepository<TagType, Long> {
    TagType findByTagType(String tagTypeName);
}
