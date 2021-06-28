package com.example.bodeguinmicroinventario.service;

import com.example.bodeguinmicroinventario.dto.CreateProductoDto;
import com.example.bodeguinmicroinventario.dto.ProducDto;

import com.example.bodeguinmicroinventario.exceptions.ProductoNotFoundException;

import java.util.List;
import java.util.Optional;


public interface InventoryService {
    ProducDto getProductobyId(Long productoid) throws ProductoNotFoundException;
    ProducDto getProductByName(String nombre) throws ProductoNotFoundException;
    List<ProducDto> getProductos() throws ProductoNotFoundException;
    ProducDto createProducto(CreateProductoDto createProductoDto) throws ProductoNotFoundException;
    void DeleteById(Long id);

}
