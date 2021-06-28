package com.example.bodeguinmicroinventario.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel(description = "Clase del producto en la orden")
@AllArgsConstructor
public class ProductTiendaDto {
    @ApiModelProperty(notes= "ID del producto",required = true)
    private Long id;
    @ApiModelProperty(notes= "stock de productos en la tienda",required = true,position = 1)
    private int stock;
    @ApiModelProperty(notes= "pprecio de productos la tienda",required = true,position =2)
    private double precio;
    @ApiModelProperty(notes= "Categoria del producto de la tienda",required = true,position =3)
    private Categoriadto categoria;

}
