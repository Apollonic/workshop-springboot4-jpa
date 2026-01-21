package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //Implementa as regras de negócio(regras de negócio = limitações ou formas específicas de executar tal ação)
    //Orquestra as operações
    //cuida de validações (como no findall, eu poderia limitar ele a usuários ou verificar se um usuário existe antes de salvar ele em...
    // uma operação de PUT)
    //Chama um repository quando precisa de dados(como na findAll que ele usa o UserRepository para usar os dados de todos os usuários)

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        //implementa a exceção criada
        return obj.orElseThrow(()-> new ResouceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
