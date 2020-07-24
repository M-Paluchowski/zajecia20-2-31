package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.form.UserForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getAll(@RequestParam(required = false) String name) {
        return List.of(new User(1L, "Marcin", "Pa"), new User(2L, "Rafał", "Pa"));
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        System.out.println(id);
        return new User(id, "Marcin", "Pa");
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserForm userForm) {
        User newUser = new User(4L, userForm.getFirstName(), userForm.getLastName());
        URI uri = UriComponentsBuilder.fromPath("/api/users/{id}")
                .build(4L);
        return ResponseEntity.created(uri).body(newUser);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserForm userForm) {
        //edycja
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        //usunięcie
    }
}
