package com.example.bodeguinmicroinventario.controllers;

import com.example.bodeguinmicroinventario.dto.Categoriadto;
import com.example.bodeguinmicroinventario.dto.CreateCategoriaDto;
import com.example.bodeguinmicroinventario.entities.Categoria;
import com.example.bodeguinmicroinventario.exceptions.ProductoNotFoundException;
import com.example.bodeguinmicroinventario.service.CategoriaService;
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
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/{categoriaid}")
    public ResponseEntity<Categoriadto> getCategoriaById(@PathVariable Long categoriaid){
        return new ResponseEntity<>(categoriaService.getCategoriaById(categoriaid),HttpStatus.OK);
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoriadto>> getCategorias(){
        return new ResponseEntity<>(categoriaService.getCategorias(),HttpStatus.OK);
    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoriadto> createCategoria(@RequestBody CreateCategoriaDto createCategoriaDto){
        return new ResponseEntity<>(categoriaService.createCategoria(createCategoriaDto), HttpStatus.OK);
    }


}
