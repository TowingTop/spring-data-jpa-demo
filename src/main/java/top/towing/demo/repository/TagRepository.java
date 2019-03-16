package top.towing.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import top.towing.demo.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);
}
