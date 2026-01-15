package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    //Implementa as regras de negócio(regras de negócio = limitações ou formas específicas de executar tal ação)
    //Orquestra as operações
    //cuida de validações (como no findall, eu poderia limitar ele a usuários ou verificar se um usuário existe antes de salvar ele em...
    // uma operação de PUT)
    //Chama um repository quando precisa de dados(como na findAll que ele usa o CategoryRepository para usar os dados de todos os usuários)

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
