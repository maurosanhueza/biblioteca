package com.maurosanhueza.biblioteca.repositories;

import com.maurosanhueza.biblioteca.models.Autor;
import com.maurosanhueza.biblioteca.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
}
