package com.example.demo;

import com.example.demo.dao.TagRepository;
import com.example.demo.dao.TagTypeRepository;
import com.example.demo.domain.Tag;
import com.example.demo.domain.TagType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DemoRunner implements ApplicationRunner {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagTypeRepository tagTypeRepository;

    @Override
    public void run(ApplicationArguments var) throws Exception{
        // load tag types to db
        List<String> tagTypeNames = Arrays.asList("positive", "negative", "neutral");
        List<TagType> tagTypes = tagTypeNames.stream().map(
                tagTypeName -> {
                    TagType tagType = new TagType();
                    tagType.setTagType(tagTypeName);
                    return tagType;
                }).collect(Collectors.toList());
        tagTypes.forEach(tagType -> tagTypeRepository.save(tagType));

        // load tags to db
        List<String> tagNames = Arrays.asList("foo", "bar", "baz", "qux", "quux", "quuz", "corge");
        List<Tag> tags  = tagNames.stream().map(
                tagName -> {
                    Tag tag = new Tag();
                    tag.setTagName(tagName);
                    tag.setTagType(getTagTypeAtRandom(tagTypeNames));
                    return tag;
                }).collect(Collectors.toList());
        tags.forEach(tag -> tagRepository.save(tag));
    }

    private TagType getTagTypeAtRandom(List<String> tagTypeNames) {
        Collections.shuffle(tagTypeNames);
        String tagTypeName = tagTypeNames.get(0);
        return tagTypeRepository.findByTagType(tagTypeName);
    }
}
