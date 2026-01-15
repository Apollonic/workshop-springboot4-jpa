package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    //A camada Resources/Controller serve para receber as requisições HTTP (GET,POST,DELETE,PUT)
    //Chama a camada de serviço
    //E devolve a resposta ao cliente
    //O controller *NÃO* faz regra de negócio.

    @Autowired
    private UserService service;

    //a anotação @ serve para mapear que esse metodo é a corresponder ao get
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //o value = "/{id}" serve para a URL aceitar o ID, por exemplo :http:/blablabla/*ID*
    //@PathVAriable serve pra URL aceitar esse id como o valor de id
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
