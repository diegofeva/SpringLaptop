package com.example.SpringEjercicio4.controllers;

import com.example.SpringEjercicio4.entities.Laptop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> result= testRestTemplate.getForEntity("/api/laptopss", Laptop[].class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(200,result.getStatusCodeValue());
        List<Laptop> laptops = Arrays.asList(result.getBody());
        System.out.println(laptops.size());
    }

    @Test
    void findoneById() {
        ResponseEntity<Laptop> result = testRestTemplate.getForEntity("/api/laptops/1",Laptop.class);
        assertEquals(HttpStatus.OK,result.getStatusCode());
        assertEquals(200,result.getStatusCodeValue());

    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json=
                """
                {
                   
                   "manufacturer": "hppp",
                   "modelName": "d1pp",
                   "bateryCapacity": 45,
                   "os": "Windows"
                }                     
                        """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> result = testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);

        Laptop laptop = result.getBody();
        assertTrue(laptop.getId() != null);
        assertEquals(HttpStatus.OK,result.getStatusCode());
        assertEquals(200,result.getStatusCodeValue());
    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json =
                """
                {                   
                   "id":1,
                   "manufacturer": "hppp",
                   "modelName": "d1pp",
                   "bateryCapacity": 45,
                   "os": "Windows"
                }                
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops",HttpMethod.PUT,request,Laptop.class);
        Laptop laptop = response.getBody();
        assertTrue(laptop.getId() != null);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());
        }



    @Test
    void delete() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json=
                """
                {                   
                   
                   "manufacturer": "hppp",
                   "modelName": "d1pp",
                   "bateryCapacity": 45,
                   "os": "Windows"
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);
        Laptop laptop = response.getBody();
        assertTrue(laptop.getId() !=null);


        HttpHeaders headers2 = new HttpHeaders();
        headers2.setContentType(MediaType.APPLICATION_JSON);
        headers2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json2=
                """
                {                   
                   "id":1,
                   "manufacturer": "hppp",
                   "modelName": "d1pp",
                   "bateryCapacity": 45,
                   "os": "Windows"
                }
                """;

        HttpEntity<String> request2 = new HttpEntity<>(json2,headers2);
        ResponseEntity<Laptop> response2 = testRestTemplate.exchange("/api/laptops/1",HttpMethod.DELETE,request,Laptop.class);

        assertTrue(response2.getBody() == null);
        assertEquals(HttpStatus.NO_CONTENT,response2.getStatusCode());
        assertEquals(204,response2.getStatusCodeValue());

    }

    @Test
    void deleteAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json =
                """
                {                   
                   
                   "manufacturer": "hppp",
                   "modelName": "d1pp",
                   "bateryCapacity": 45,
                   "os": "Windows"
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);
        Laptop laptop = response.getBody();
        assertTrue(laptop.getId() !=null);


        //ResponseEntity<Laptop> response2 = testRestTemplate.getForEntity("/api/laptops",Laptop.class);


        //assertEquals(HttpStatus.NO_CONTENT,response2.getStatusCode());
        //assertEquals(204,response2.getStatusCodeValue());






    }
}