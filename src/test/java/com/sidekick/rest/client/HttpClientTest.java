package com.sidekick.rest.client;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class HttpClientTest {

    private HttpClient client;

    @Before
    public void setup() {
        HttpConfig config = new HttpConfig();
        config.setConnectTimeout(10);
        config.setReadTimeout(10);
        config.setWriteTimeout(10);

        client = new HttpClient(config);
        client.setBaseUrl("https://jsonplaceholder.typicode.com");
    }

    @Test
    public void getPosts() {
        HttpResponse response = client.get(new HttpArgs().withUrl("posts"));
        assertEquals(response.getCode(), 200);
        List posts = (List) response.getJson();
        assertEquals(posts.size(), 100);
        Map post = (Map) posts.get(0);

        assertEquals(1, post.get("id"));
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", post.get("title"));
    }

    @Test
    public void getPost() {
        HttpResponse response = client.get(new HttpArgs().withUrl("posts/1"));
        Map post = (Map) response.getJson();

        assertEquals(200, response.getCode());
        assertEquals(1, post.get("id"));
    }

    @Test
    public void getCommentsOfPost() {
        Map<String, String> query = new HashMap<>();
        query.put("postId", "1");
        HttpResponse response = client.get(new HttpArgs()
                .withUrl("comments")
                .withQuery(query)
        );

        assertEquals(200, response.getCode());
    }

    @Test
    public void createPost() {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "foo");
        body.put("body", "bar");
        body.put("userId", 1);
        HttpResponse response = client.post(new HttpArgs()
                .withUrl("posts")
                .withBody(body)
        );
        Map post = (Map) response.getJson();

        assertEquals(201, response.getCode());
        assertEquals(101, post.get("id"));
    }
}
