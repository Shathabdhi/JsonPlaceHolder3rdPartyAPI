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
    String post = "posts";
    String POSTBYID = "posts/";
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
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
//       val response = restTemplate.exchange(url, HttpMethod.GET,httpEntity, Map.class);
        val response = restTemplate.exchange(url, HttpMethod.GET,httpEntity, Map.class,id);
        //System.out.println(restTemplate.getForEntity());
        return response.getBody();
    }

    @Override
    public Map<String, Object> insertPosts(Map<String, Object> payload) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(payload,gethttpHeaders());
        String url = "https://jsonplaceholder.typicode.com/posts";
        val response = restTemplate.exchange(url, HttpMethod.POST,httpEntity, Map.class,payload);
        return response.getBody();
    }

    @Override
    public Map<String, Object> updatePosts(Map<String,Object> payload,int id) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(payload,gethttpHeaders());
        String url = "https://jsonplaceholder.typicode.com/"+ "{POSTBYID}"+"{id}";
        val response = restTemplate.exchange(url, HttpMethod.PUT,httpEntity, Map.class,payload,id);
        return response.getBody();
    }

    @Override
    public Map<String, Object> deletePost(int id) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(gethttpHeaders());
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        val response = restTemplate.exchange(url, HttpMethod.DELETE,httpEntity, Map.class,id);
        return response.getBody();
    }


    //We need a http entity to pass into the HTTP method in the above method so creating the below
     private HttpHeaders gethttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
