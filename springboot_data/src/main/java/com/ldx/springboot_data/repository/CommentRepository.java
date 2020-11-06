package com.ldx.springboot_data.repository;

import com.ldx.springboot_data.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
