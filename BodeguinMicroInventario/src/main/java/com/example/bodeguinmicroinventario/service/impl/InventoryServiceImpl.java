package com.example.bodeguinmicroinventario.service.impl;

import com.example.bodeguinmicroinventario.dto.CreateProductoDto;
import com.example.bodeguinmicroinventario.dto.ProducDto;
import com.example.bodeguinmicroinventario.entities.Categoria;
import com.example.bodeguinmicroinventario.entities.Producto;
import com.example.bodeguinmicroinventario.exceptions.ProductoNotFoundException;
import com.example.bodeguinmicroinventario.repositories.CategoriaRepository;
import com.example.bodeguinmicroinventario.repositories.ProductoRepository;
import com.example.bodeguinmicroinventario.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    private static final ModelMapper modelmapper =new ModelMapper();

    @Override
    public ProducDto getProductobyId(Long productoid) throws ProductoNotFoundException {
        Producto data =getProductEntity(productoid);
        ProducDto map= modelmapper.map(getProductEntity(productoid),ProducDto.class);
        //map.setCategoriaid(data.getCategoria().getId());
        return map;
    }

    @Override
    public ProducDto getProductByName(String nombre) throws ProductoNotFoundException {
        Producto data =getProductEntity(nombre);
        ProducDto map= modelmapper.map(getProductEntity(nombre),ProducDto.class);
        //map.setCategoriaid(data.getCategoria().getId());
        return map;
    }

    @Override
    public List<ProducDto> getProductos() throws ProductoNotFoundException {
        List<Producto> productEntity = productoRepository.findAll();
        Stream<ProducDto> maps= productEntity.stream().map(producto -> modelmapper.map(producto,ProducDto.class));
        List<ProducDto> arrayM= maps.collect(Collectors.toList());
        for(ProducDto m:arrayM){
            Producto data = getProductEntity(m.getId());
            //m.setCategoriaid(data.getCategoria().getId());
        }
        return arrayM;
    }

    @Transactional
    @Override
    public ProducDto createProducto(CreateProductoDto createProductoDto) throws ProductoNotFoundException {

        Categoria categoriaid =categoriaRepository.findById(createProductoDto.getCategoria().getId())
                .orElseThrow(()-> new ProductoNotFoundException("not"));

        Producto producto= new Producto();
        producto.setNombre(createProductoDto.getNombre());
        //producto.setPrecio(createProductoDto.getPrecio());
        //producto.setStock(createProductoDto.getStock());
        //producto.setCategoria(categoriaid);
        producto.setCategoria(categoriaid);
        try{
            producto=productoRepository.save(producto);
        }catch (Exception ex){
            throw new ProductoNotFoundException("internal error");
        }
        return modelmapper.map(getProductEntity(producto.getId()),ProducDto.class);

    }


    @Transactional
    @Override
    public void DeleteById(Long id) { productoRepository.deleteById(id);

    }

    private Producto getProductEntity(Long ProductoId) throws ProductoNotFoundException{
        return productoRepository.findById(ProductoId).
                orElseThrow(()-> new ProductoNotFoundException("Notfound"));
    }
    private Producto getProductEntity(String name) throws ProductoNotFoundException{
        return productoRepository.findByNombre(name).
                orElseThrow(()-> new ProductoNotFoundException("Notfound"));
    }
}
