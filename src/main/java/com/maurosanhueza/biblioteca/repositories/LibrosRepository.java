package com.maurosanhueza.biblioteca.repositories;

import com.maurosanhueza.biblioteca.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Integer> {
}
