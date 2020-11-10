package com.ldx.springboot_cache.service;

import com.ldx.springboot_cache.pojo.Comment;
import com.ldx.springboot_cache.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // 查询方法
    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public Comment findCommentById(Integer id) {
        Optional<Comment> byId = commentRepository.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            return comment;
        }
        return null;
    }

    // 更新方法
    @CachePut(cacheNames = "comment", key = "#result.id")
    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor(), comment.getaId());
        return comment;
    }

    // 删除方法
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
