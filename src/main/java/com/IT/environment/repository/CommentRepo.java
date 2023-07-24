package com.IT.environment.repository;

import com.IT.environment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findAllByEmployee_Id(Integer id);
}
