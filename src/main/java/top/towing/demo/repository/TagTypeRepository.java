package top.towing.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import top.towing.demo.domain.TagType;

public interface TagTypeRepository extends JpaRepository<TagType, Long> {
    TagType findByTagType(String tagTypeName);
}
