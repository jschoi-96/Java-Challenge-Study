package com.example.hw1.controller;

import com.example.hw1.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Controller + ResponseBody가 결합된 어노테이션
@RequestMapping("/users")
public class UserController {

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
