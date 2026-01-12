package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    //a anotação @ serve para mapear que esse metodo é a corresponder ao get
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(null,"maria","Maroaemail","phone","23q94");
        return ResponseEntity.ok().body(u);
    }
}
