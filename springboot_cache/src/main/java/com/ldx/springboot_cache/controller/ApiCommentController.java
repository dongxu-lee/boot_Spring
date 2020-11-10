package com.ldx.springboot_cache.controller;

import com.ldx.springboot_cache.pojo.Comment;
import com.ldx.springboot_cache.service.ApiCommentService;
import com.ldx.springboot_cache.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiCommentController {

    @Autowired
    private ApiCommentService commentService;

    @RequestMapping(value = "/findCommentById")
    public Comment findCommentById(Integer id) {
        Comment byId = commentService.findCommentById(id);
        return byId;
    }

    @RequestMapping("/updateComment")
    public Comment updateComment(Comment comment) {
        Comment commentById = commentService.findCommentById(comment.getId());
        commentById.setAuthor(comment.getAuthor());
        Comment comment1 = commentService.updateComment(commentById);
        return comment1;
    }

    @RequestMapping("/deleteComment")
    public void deleteComment(Integer id) {
        commentService.deleteComment(id);
    }







}
