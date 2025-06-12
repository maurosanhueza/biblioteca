package com.maurosanhueza.biblioteca.controllers;

import com.maurosanhueza.biblioteca.models.Autor;
import com.maurosanhueza.biblioteca.models.Libros;
import com.maurosanhueza.biblioteca.services.LibrosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {

    @Autowired
    private LibrosService librosService;

    @GetMapping
    public ResponseEntity<List<Libros>> findAll(){
        List<Libros> libros = librosService.findAll();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> findById(@PathVariable int id){
        Optional<Libros> libro = librosService.findById(id);
        return libro.map(value ->new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Libros> save(@RequestBody Libros in_libros){
        Libros libro = librosService.save(in_libros);
        return new ResponseEntity<>(libro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libros> update(@PathVariable int id, @RequestBody Libros in_libro){
        Optional<Libros> libro_now = librosService.findById(id);
        if (libro_now.isPresent()){
            Libros libro_updated = libro_now.get();
            libro_updated.setTitulo(in_libro.getTitulo());
            libro_updated.setEditorial(in_libro.getEditorial());
            libro_updated.setGenero(in_libro.getGenero());
            libro_updated.setFechaedicion(in_libro.getFechaedicion());
            libro_updated.setPrecio(in_libro.getPrecio());
            return new ResponseEntity<>(librosService.save(libro_updated), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        try{
            librosService.delete(id);
            return ResponseEntity.noContent().build(); //construye un 204
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
