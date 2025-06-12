package com.maurosanhueza.biblioteca.dto;

import com.maurosanhueza.biblioteca.models.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO {

    private Integer id;
    private String nombre, apellido, telefono;

    public AutorDTO(Autor p_autor) {
        this.id = p_autor.getId();
        this.nombre = p_autor.getNombre();
        this.apellido = p_autor.getApellido();
        this.telefono = p_autor.getTelefono();
    }
}
