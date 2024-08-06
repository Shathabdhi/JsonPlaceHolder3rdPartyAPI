package com.example.thirdpartyapiintegrationspringboot.postService.impl;

import com.example.thirdpartyapiintegrationspringboot.postService.postService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class postServiceImpl implements postService {

    String baseUrl = "https://jsonplaceholder.typicode.com/";
    String post = "/posts";
    String POSTBYID = "/posts/";
    StringBuilder stringBuilder = new StringBuilder(baseUrl);
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Map<String, Object>> getPosts() {
        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
        String url = stringBuilder.append(post).toString();
        val response = restTemplate.exchange(url, HttpMethod.GET,httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> getPostById(int id) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
        String url = stringBuilder.append(POSTBYID).append(id).toString();
        System.out.println("MY URL = "+url);
        val response = restTemplate.exchange(url, HttpMethod.GET,httpEntity, Map.class);
        return response.getBody();
    }

    private HttpHeaders gethttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
