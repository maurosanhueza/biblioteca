package com.maurosanhueza.biblioteca.services;

import com.maurosanhueza.biblioteca.models.Autor;
import com.maurosanhueza.biblioteca.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll(){

        return autorRepository.findAll();
    }

    public Optional<Autor> findById(Integer id){
        return autorRepository.findById(id);
    }

    public Autor save(Autor autor){

        return (Autor) autorRepository.save(autor);
    }

    public Autor update(int id, Autor autor){
        Autor autor_now = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no existe" + id));
        return autorRepository.save(autor_now);
    }

    public void delete(Integer id){

        autorRepository.deleteById(id);
    }

}
