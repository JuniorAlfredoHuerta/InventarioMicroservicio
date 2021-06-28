package com.example.bodeguinmicroinventario.controllers;

import com.example.bodeguinmicroinventario.dto.CreateProductoDto;
import com.example.bodeguinmicroinventario.dto.ProducDto;
import com.example.bodeguinmicroinventario.dto.ProductTiendaDto;
import com.example.bodeguinmicroinventario.entities.Categoria;
import com.example.bodeguinmicroinventario.entities.Producto;
import com.example.bodeguinmicroinventario.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Slf4j
@Api
@RestController
@RequestMapping(path = "/inventario")
public class InventoryControllers {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/product/{productoId}")
    public ResponseEntity<ProducDto> getProductobyId(@PathVariable Long productoId){
        return new ResponseEntity<>(inventoryService.getProductobyId(productoId),HttpStatus.OK);
    }

    @GetMapping("/productn/{nombrepro}")
    public ResponseEntity<ProducDto> getProductobyName(@PathVariable String nombrepro){
        return new ResponseEntity<>(inventoryService.getProductByName(nombrepro),HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProducDto>>getProductos(){
        return new ResponseEntity<>(inventoryService.getProductos(),HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ProducDto> createProducto(@RequestBody CreateProductoDto createProductoDto){
        return new ResponseEntity<>(inventoryService.createProducto(createProductoDto),HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/productdi/{id}")
    public void deleteById(@PathVariable Long id ){this.inventoryService.DeleteById(id);}




}
