package com.example.bodeguinmicroinventario.dto;

import io.swagger.annotations.ApiModelProperty;

public class VendedorDto

{
    @ApiModelProperty(notes = "Id interno de un vendedor en la base de datos", example = "1")
    private Integer id;

    @ApiModelProperty(notes = "Nombre del vendedor", example = "Jose")
    private String nombre;
    @ApiModelProperty(notes = "DNI con el que se identifica el vendedor", example = "12345667")
    private String dni;
}
