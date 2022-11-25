package com.example.demo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.demo.DemoApplication.Author;
import com.example.demo.DemoApplication.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldGetListOfBooks() throws Exception {
        var books = this.restTemplate.getForObject("http://localhost:" + port + "/books",
                Book[].class);

        assertEquals(books.length, 4);
    }

    @Test
    public void shouldGetListOfAuthors() throws Exception {
        var authors = this.restTemplate.getForObject("http://localhost:" + port + "/authors",
                Author[].class);

        assertEquals(authors.length, 2);
    }
}