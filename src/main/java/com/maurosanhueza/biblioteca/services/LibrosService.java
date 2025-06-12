package com.maurosanhueza.biblioteca.services;

import com.maurosanhueza.biblioteca.models.Autor;
import com.maurosanhueza.biblioteca.models.Libros;
import com.maurosanhueza.biblioteca.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService {

    @Autowired
    private LibrosRepository librosRepository;

    public List<Libros> findAll(){
        return librosRepository.findAll();
    }

    public Optional<Libros> findById(int id){

        return librosRepository.findById(id);
    }

    public Libros save(Libros libro){

        return librosRepository.save(libro);
    }

    public Libros update(int id, Libros libro){
        Libros libro_now = librosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no existe" + id));
        return librosRepository.save(libro_now);
    }

    public void delete(Integer id){

        librosRepository.deleteById(id);
    }
}
