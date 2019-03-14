package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.tags t JOIN FETCH t.tagType tt WHERE tt.tagType = 'positive'")
    List<User> getUsersAllPositiveTags();
}
