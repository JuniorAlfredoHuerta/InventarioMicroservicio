package com.example.bodeguinmicroinventario.service.impl;

import com.example.bodeguinmicroinventario.cliente.BodegaServiceClient;
import com.example.bodeguinmicroinventario.dto.BodegaDto;
import com.example.bodeguinmicroinventario.dto.CreateInventariodto;
import com.example.bodeguinmicroinventario.dto.InventarioDto;
import com.example.bodeguinmicroinventario.dto.ProducDto;
import com.example.bodeguinmicroinventario.entities.Inventario;
import com.example.bodeguinmicroinventario.entities.Producto;
import com.example.bodeguinmicroinventario.exceptions.ProductoNotFoundException;
import com.example.bodeguinmicroinventario.repositories.InventarioRepository;
import com.example.bodeguinmicroinventario.repositories.ProductoRepository;
import com.example.bodeguinmicroinventario.service.InventarioService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private BodegaServiceClient bodegaServiceClient;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    private static final ModelMapper modelmapper = new ModelMapper();


    @Override
    public InventarioDto getInventariobyid(Long inventarioid) {
        return modelmapper.map(getInventarioEntity(inventarioid),InventarioDto.class);
        //map.setCategoriaid(data.getCategoria().getId());

    }

    @Override
    public InventarioDto getInventariobybodegaidandproductoid(String bodegaid, Long productoid) {

        Inventario inventario= inventarioRepository.findInventarioByBodegaidAndProductoid(bodegaid,productoid)
                .orElseThrow(()->new ProductoNotFoundException("Not found"));
        return modelmapper.map(inventario,InventarioDto.class);
    }

    /*@Override
    public InventarioDto getProductoId(String bodegaid, Long productoid) {

        return null;
    }*/


    @Override
    public List<InventarioDto> getAll() {
        List<Inventario> InventarioEntity = inventarioRepository.findAll();
        Stream<InventarioDto>  maps=  InventarioEntity.stream().
                map(inventario -> modelmapper.map(inventario,InventarioDto.class));
        List<InventarioDto> arrayM=maps.collect(Collectors.toList());
        for(InventarioDto m:arrayM){
            Inventario data = getInventarioEntity(m.getId());
        }
        return arrayM;
    }

    @Transactional
    @Override
    public InventarioDto createInventario(CreateInventariodto createInventariodto) {

        BodegaDto bodegaDto = bodegaServiceClient.findAccount(createInventariodto.getBodegaid())
                .orElseThrow(()-> new ProductoNotFoundException("Not found"));

        log.info("Bodega: ",bodegaDto);


        Producto producto= productoRepository.findById(createInventariodto.getProductoid().getId())
                .orElseThrow(()-> new ProductoNotFoundException("Notfound"));

        Inventario inventario= new Inventario();
        inventario.setStock(createInventariodto.getStock());
        inventario.setPrecio(createInventariodto.getPrecio());
        inventario.setBodegaid(createInventariodto.getBodegaid());
        inventario.setProductoid(producto);

        try{
            inventario=inventarioRepository.save(inventario);
        }catch (Exception ex){
            throw new ProductoNotFoundException("ERROR");
        }
        return modelmapper.map(getInventarioEntity(inventario.getId()), InventarioDto.class);

    }

    private Inventario getInventarioEntity(Long inventarioid) throws ProductoNotFoundException {
        return inventarioRepository.findById(inventarioid)
                .orElseThrow(()->new ProductoNotFoundException("notfound"));
    }
    private Producto getProductEntity(Long ProductoId) throws ProductoNotFoundException{
        return productoRepository.findById(ProductoId).
                orElseThrow(()-> new ProductoNotFoundException("Notfound"));
    }

}
