package com.maurosanhueza.biblioteca.controllers;

import com.maurosanhueza.biblioteca.models.Autor;
import com.maurosanhueza.biblioteca.services.AutorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.EntityDeclaration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        List<Autor> autores = autorService.findAll();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> findById(@PathVariable int id){
        Optional<Autor> autor = autorService.findById(id);
        return autor.map(value ->new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Autor> save(@RequestBody Autor in_autor){
        Autor autor = autorService.save(in_autor);
        return new ResponseEntity<>(autor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> update(@PathVariable int id, @RequestBody Autor in_autor){
        Optional<Autor> autor_now = autorService.findById(id);
        if (autor_now.isPresent()){
            Autor autor_updated = autor_now.get();
            autor_updated.setNombre(in_autor.getNombre());
            autor_updated.setApellido(in_autor.getApellido());
            autor_updated.setTelefono(in_autor.getTelefono());
            return new ResponseEntity<>(autorService.save(autor_updated), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        try{
            autorService.delete(id);
            return ResponseEntity.noContent().build(); //construye un 204
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
