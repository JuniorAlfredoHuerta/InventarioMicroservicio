package com.example.bodeguinmicroinventario.service;

import com.example.bodeguinmicroinventario.dto.CreateInventariodto;
import com.example.bodeguinmicroinventario.dto.InventarioDto;

import java.util.List;

public interface InventarioService {
    InventarioDto getInventariobyid(Long inventarioid);
    //InventarioDto getProductoId(String bodegaid,Long productoid);
    //List<InventarioDto> getBodegabyId(String bodegaid);
    InventarioDto getInventariobybodegaidandproductoid(String bodegaid,Long productoid);
    List<InventarioDto> getAll();
    InventarioDto createInventario(CreateInventariodto createInventariodto);
}
