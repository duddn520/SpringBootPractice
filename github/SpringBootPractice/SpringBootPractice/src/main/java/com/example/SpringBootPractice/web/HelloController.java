package com.example.SpringBootPractice.web;

import com.example.SpringBootPractice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")   //requestparam -> 외부에서 특정 이름으로 넘긴 파라미터를 메소드 파라미터에 저장
    public HelloResponseDto helloResponseDto (@RequestParam("name") String name, @RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name,amount);
    }

}
