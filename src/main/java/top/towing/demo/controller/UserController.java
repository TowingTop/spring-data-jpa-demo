package top.towing.demo.controller;

import top.towing.demo.domain.Tag;
import top.towing.demo.domain.User;
import top.towing.demo.repository.TagRepository;
import top.towing.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping(path = "/users/add")
    public void addNewUser() {
        // user : David Tong
        User user = new User();
        user.setUserName("David Tong");

        // look up my tags
        List<String> tagNames = Arrays.asList("foo", "bar", "baz", "corge");
        List<Tag> tags  = tagNames.stream().map(tagName -> {
            Tag tag = tagRepository.findByTagName(tagName);
            return tag;
        }).collect(Collectors.toList());
        user.setTags(tags);

        // user : ytong82
        User user2 = new User();
        user2.setUserName("ytong82");

        // look up my tags
        List<String> tagNames2 = Arrays.asList("qux", "quux", "quuz");
        List<Tag> tags2  = tagNames2.stream().map(tagName -> {
            Tag tag = tagRepository.findByTagName(tagName);
            return tag;
        }).collect(Collectors.toList());
        user2.setTags(tags2);

        // persist
        userRepository.save(user);
        userRepository.save(user2);

    }

    @GetMapping(path = "/users/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/tags/positive")
    @ResponseBody
    public Iterable<User> getUsersAllPositiveTags() {
        return userRepository.getUsersAllPositiveTags();
    }
}
