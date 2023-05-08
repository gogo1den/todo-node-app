package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// v03
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("/testGetMapping")
    public String testController() {
        return "Hello World, 최승훈";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required=false) int id) {
        return "Hello World, 최승훈" + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerWithRequestParam(@RequestParam(required=false) int id) {
        return "Hello World, 최승훈" + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerWithRequestParam(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World, 최승훈. id: " + testRequestBodyDTO.getId() + ", message: "
                + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResposeBody() {
        List<String> list = new ArrayList<>();
        list.add("csh");
        list.add("csh2");
        list.add("csh3");

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return response;

    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResposeEntity() {
        List<String> list = new ArrayList<>();
        list.add("csh");
        list.add("csh2");
        list.add("csh3");

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.ok().body(response);
        //return ResponseEntity.badRequest().body(response);

    }
}
