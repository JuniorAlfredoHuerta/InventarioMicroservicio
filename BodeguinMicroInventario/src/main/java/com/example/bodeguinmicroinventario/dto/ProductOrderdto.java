package com.example.bodeguinmicroinventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@ApiModel(description = "Clase del producto en la orden")
@AllArgsConstructor
public class ProductOrderdto {
    @ApiModelProperty(notes= "ID del producto",required = true)
    private Long id;
    @ApiModelProperty(notes= "Cantidad de productos la orden",required = true,position = 1)
    private int cantidad;
    @ApiModelProperty(notes= "precio de productos la orden",required = true,position =2)
    private double precio;
    @ApiModelProperty(notes= "Categoria del producto de la orden",required = true,position =3)
    private Categoriadto categoria;


}
