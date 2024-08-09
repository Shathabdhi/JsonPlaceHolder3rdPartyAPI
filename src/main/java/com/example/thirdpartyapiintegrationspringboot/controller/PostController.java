package com.example.thirdpartyapiintegrationspringboot.controller;

import com.example.thirdpartyapiintegrationspringboot.postService.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    Map<String,Object>getPostsById(@PathVariable int id){
        return postService1.getPostById(id);
    }
    @PostMapping("/insertPosts")
    Map<String,Object>insertPost(@RequestBody Map<String,Object> payload){
        return postService1.insertPosts(payload);
    }

    @PutMapping("/updatePosts/{id}")
    Map<String,Object>updatePosts(@RequestBody Map<String,Object> payload,int id){
        return postService1.updatePosts(payload,id);
    }
    @DeleteMapping("/deletePosts/{id}")
    Map<String,Object>deletePost(@PathVariable int id){
        return postService1.deletePost(id);
    }
}
