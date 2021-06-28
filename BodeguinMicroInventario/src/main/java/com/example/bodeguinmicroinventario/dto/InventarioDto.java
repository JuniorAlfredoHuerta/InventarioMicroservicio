package com.example.bodeguinmicroinventario.dto;

import com.example.bodeguinmicroinventario.entities.Inventario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventarioDto {
    private Long id;
    private Integer stock;
    private Integer precio;
    private String bodegaid;
    private ProducDto productoid;




}
