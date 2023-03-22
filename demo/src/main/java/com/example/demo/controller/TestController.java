package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("/testGetMapping")
    public String testController() {
        return "Hello World!, 박고은";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false)int id)
    {
        return "Hello World! 박고은 " + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false)int id)
    {
        return "Hello World! 박고은 " + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO TestRequestBodyDTO) {
        return "Hello World! 박고은. id : " + TestRequestBodyDTO.getId() + ", message : " + TestRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("pge");
        list.add("pge2");
        list.add("pge3");

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        //return ResponseEntity.ok().body(response);
        return ResponseEntity.badRequest().body(response);
    }
}
