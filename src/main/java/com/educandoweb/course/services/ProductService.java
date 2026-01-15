package com.educandoweb.course.services;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //Implementa as regras de negócio(regras de negócio = limitações ou formas específicas de executar tal ação)
    //Orquestra as operações
    //cuida de validações (como no findall, eu poderia limitar ele a usuários ou verificar se um usuário existe antes de salvar ele em...
    // uma operação de PUT)
    //Chama um repository quando precisa de dados(como na findAll que ele usa o ProductRepository para usar os dados de todos os usuários)

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
