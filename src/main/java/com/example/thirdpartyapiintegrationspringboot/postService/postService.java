package com.example.thirdpartyapiintegrationspringboot.postService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface postService {
    List<Map<String, Object>>getPosts();

    Map<String,Object>getPostById(int id);
}
