package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//a anotation @repositoy aqui não é necessária pq a classe herda de uma que já está registrada como um componente do Spring
public interface CategoryRepository extends JpaRepository<Category,Long> {
    //Fala diretamente com o Banco de dados
    //Faz consultas (SQL gerado pelo Spring Data JPA)
    //Salva, busca, atualiza e deleta dados

    //Essa classe n tem nada pq o JpaRepository já cria e implementa automaticamente as coisas do repositório

    /*

    JPA → regras de persistência (Persistência de dados = tornar dados “duráveis” fora da memória do programa)
    Hibernate → motor que executa JPA
    Spring Data JPA → facilita e automatiza o uso do JPA no Spring Boot, principalmente na camada Repository

    */

}
