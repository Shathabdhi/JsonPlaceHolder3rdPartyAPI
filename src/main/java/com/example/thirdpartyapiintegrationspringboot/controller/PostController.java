package com.example.thirdpartyapiintegrationspringboot.controller;

import com.example.thirdpartyapiintegrationspringboot.postService.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private postService postService1;
    @GetMapping("/getPosts")
    List<Map<String,Object>> getAllPosts(){
        return postService1.getPosts();
    }
    @GetMapping("/getPostsById/{id}")
    Map<String,Object>getAllPosts(@PathVariable int id){
        return postService1.getPostById(id);
    }

}
