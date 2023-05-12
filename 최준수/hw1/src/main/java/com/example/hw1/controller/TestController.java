package com.example.hw1.controller;

import com.example.hw1.MemberService;
import com.example.hw1.MemberServiceImpl;
import com.example.hw1.dto.LottoDto;
import com.example.hw1.dto.UserDto;
import com.example.hw1.dto.scoreDto;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // Controller + ResponseBody가 결합된 어노테이션
// @RequestMapping("/users")
public class TestController {

    MemberService memberService = new MemberServiceImpl();

    @PostMapping("user")
    public UserDto user(@RequestBody UserDto userDto){
        UserDto request = UserDto.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
        return memberService.userEmail(request);
    }


    @GetMapping("/lottoTest")
    public List<Integer> lottoTest(){
        return memberService.LottoNum(6);
    }

    @PostMapping("/scoreTest")
    public void scoreTest(@RequestBody List<scoreDto> scores) {
        System.out.println(scores);
    }



    @GetMapping(path="/{userId}")
    public ResponseEntity <UserDto> getUser(@PathVariable String userId) {
        UserDto userDto = UserDto.builder()
                        .name(userId)
                        .email("choix712@umn.edu").build();
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "50") int limit
            , @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort ){
        return "get users was called with page = " + page + " and limit = " + limit + " and sort type is " + sort;
    }

    @PostMapping
    public String createUser(){
        return "create users was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }

}
