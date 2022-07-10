package com.example.idflab.controller;

import com.example.idflab.entity.User;
import com.example.idflab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> save (@RequestBody User user){
        User save = userRepository.save(user);
        return  ResponseEntity.ok(save);
    }


    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/findById")
    public ResponseEntity<User> findById (Long id){
        Optional<User> byId = userRepository.findById(id);
        return byId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
