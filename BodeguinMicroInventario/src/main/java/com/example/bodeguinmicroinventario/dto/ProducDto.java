package com.example.bodeguinmicroinventario.dto;


import com.example.bodeguinmicroinventario.entities.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducDto {
    private Long id;
    private String nombre;
    //private Integer precio;
    //private Integer stock;
    //private Categoria categoria;
    private Categoriadto categoria;

}
