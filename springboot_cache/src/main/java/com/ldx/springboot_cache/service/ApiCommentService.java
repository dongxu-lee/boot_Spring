package com.ldx.springboot_cache.service;

import com.ldx.springboot_cache.pojo.Comment;
import com.ldx.springboot_cache.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class ApiCommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 使用redisAPI方式进行缓存
     * @param id
     * @return
     */

    @Autowired
    private RedisTemplate redisTemplate;

    // 查询方法
    public Comment findCommentById(Integer id) {
        Object o = redisTemplate.opsForValue().get("comment_" + id);
        if (o != null) {
            return (Comment) o;
        }else {
            Optional<Comment> byId = commentRepository.findById(id);
            if (byId.isPresent()) {
                Comment comment = byId.get();
                // 放入缓存，同时设置有效期1天
                redisTemplate.opsForValue().set("comment_" + id,comment, 1, TimeUnit.DAYS);
                return comment;
            }
        }
        return null;
    }

    // 更新方法
    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor(), comment.getaId());
        // 更新缓存
        redisTemplate.opsForValue().set("comment_" + comment.getId(), comment);
        return comment;
    }

    // 删除方法
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
        redisTemplate.delete("comment_" + id);
    }
}
