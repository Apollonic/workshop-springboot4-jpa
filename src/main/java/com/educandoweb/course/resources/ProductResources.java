package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    //A camada Resources/Controller serve para receber as requisições HTTP (GET,POST,DELETE,PUT)
    //Chama a camada de serviço
    //E devolve a resposta ao cliente
    //O controller *NÃO* faz regra de negócio.

    @Autowired
    private ProductService service;

    //esses @getMapping são Endpoints!!
    //o GetMapping é um exemplo de Endpoint do get. Mas pode ter de PUT, DELETE etc

    //a anotação @ serve para mapear que esse metodo é a corresponder ao get
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //o value = "/{id}" serve para a URL aceitar o ID, por exemplo :http:/blablabla/*ID*
    //@PathVAriable serve pra URL aceitar esse id como o valor de id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
