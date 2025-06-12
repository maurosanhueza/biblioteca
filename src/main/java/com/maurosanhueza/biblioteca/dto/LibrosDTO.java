package com.maurosanhueza.biblioteca.dto;

import com.maurosanhueza.biblioteca.models.Autor;
import com.maurosanhueza.biblioteca.models.Libros;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LibrosDTO {

    private Integer id;
    private String titulo, editorial, genero;
    private BigDecimal precio;
    private LocalDate fechaedicion;
    private AutorDTO autorDTO;

    public LibrosDTO(Libros p_libros) {
        this.id = p_libros.getId();
        this.titulo = p_libros.getTitulo();
        this.editorial = p_libros.getEditorial();
        this.genero = p_libros.getGenero();
        this.precio = p_libros.getPrecio();
        this.fechaedicion = p_libros.getFechaedicion();
        autorDTO = new AutorDTO((p_libros.getAutor()));
    }
}
