package com.example.assiment7.Controller;

import com.example.assiment7.Dio.Api;
import com.example.assiment7.Service.Userservice;
import com.example.assiment7.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class Usercontroller {
    private final Userservice userservice;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> blogs= userservice.getUser();
        return ResponseEntity.status(200).body(blogs);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(User user,  Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message);
        }
       userservice.addUser(user);
        return ResponseEntity.status(200).body (new Api("Add user"));
    }
    @PutMapping("/update")
    public ResponseEntity updateUser(@PathVariable @Valid Integer id, User user, Errors errors){
        if (errors.hasErrors()){

            return ResponseEntity.status(400).body (errors.getFieldError().getDefaultMessage());
        }
        userservice.updateUser(id,user);

        return ResponseEntity.status(200).body(new Api(" user Updated"));

    }
    @DeleteMapping("/delete")
    public String deletUser (@PathVariable @Valid Integer id){
        userservice.deleteUser(id);
        return "user DELETED";}
}
