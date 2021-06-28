package com.example.bodeguinmicroinventario.controllers;

import com.example.bodeguinmicroinventario.dto.CreateInventariodto;
import com.example.bodeguinmicroinventario.dto.CreateProductoDto;
import com.example.bodeguinmicroinventario.dto.InventarioDto;
import com.example.bodeguinmicroinventario.dto.ProducDto;
import com.example.bodeguinmicroinventario.service.InventarioService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api
@RestController
@RequestMapping(path = "/inventario")
public class InventarioController {

    @Autowired
    public InventarioService inventarioService;

    @GetMapping("/inventario/{id}")
    public ResponseEntity<InventarioDto> getbyID(@PathVariable Long id){
        return new ResponseEntity<>(inventarioService.getInventariobyid(id), HttpStatus.OK);
    }

    /*@GetMapping("/inventario/{bodegaid}/{productoid}")
    public ResponseEntity<InventarioDto> getBodega_Productobyid(@PathVariable String bodegaid,
                                                                @PathVariable Long productoid){
        return new ResponseEntity<>(inventarioService.getProductoId(bodegaid,productoid), HttpStatus.OK);

    }*/

    @GetMapping("/inventariototal/{bodegaid}/{productoid}")
    public ResponseEntity<InventarioDto> getByBidPid(@PathVariable String bodegaid, @PathVariable Long productoid){
        return new ResponseEntity<>(inventarioService.getInventariobybodegaidandproductoid(bodegaid,productoid),HttpStatus.OK);
    }

    @GetMapping("/inventariototal")
    public ResponseEntity<List<InventarioDto>> getALL(){
        return new ResponseEntity<>(inventarioService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/inventariototal")
    public ResponseEntity<InventarioDto> createInventario(@RequestBody CreateInventariodto createInventariodto){
        return new ResponseEntity<>(inventarioService.createInventario(createInventariodto),HttpStatus.OK);
    }



}
