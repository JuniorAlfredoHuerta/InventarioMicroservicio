package com.example.bodeguinmicroinventario.service.impl;

import com.example.bodeguinmicroinventario.dto.Categoriadto;
import com.example.bodeguinmicroinventario.dto.CreateCategoriaDto;
import com.example.bodeguinmicroinventario.entities.Categoria;
import com.example.bodeguinmicroinventario.exceptions.ProductoNotFoundException;
import com.example.bodeguinmicroinventario.repositories.CategoriaRepository;
import com.example.bodeguinmicroinventario.service.CategoriaService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    private static final ModelMapper modelmapper = new ModelMapper();

    @Override
    public Categoriadto getCategoriaById(Long categoriaid) throws ProductoNotFoundException {
        return modelmapper.map(getCategoriasEntity(categoriaid),Categoriadto.class);
    }

    @Transactional
    @Override
    public Categoriadto createCategoria(CreateCategoriaDto createCategoriaDto) throws ProductoNotFoundException {
        Categoria categoria = new Categoria();
        categoria.setNombre(createCategoriaDto.getNombre());
        categoria.setDescripcion(createCategoriaDto.getDescripcion());
        try{
            categoria=categoriaRepository.save(categoria);
        }catch (Exception ex){
            throw new ProductoNotFoundException("internal error");
        }
        return modelmapper.map(getCategoriasEntity(categoria.getId()),Categoriadto.class);
    }

    @Override
    public List<Categoriadto> getCategorias() throws ProductoNotFoundException {
        List<Categoria> cat=categoriaRepository.findAll();
        return cat.stream().map(categoria -> modelmapper.map(categoria,Categoriadto.class)).collect(Collectors.toList());

    }

    private Categoria getCategoriasEntity(Long categoriaid) throws ProductoNotFoundException{
        return categoriaRepository.findById(categoriaid).orElseThrow(()-> new ProductoNotFoundException("Not Found"));
    }


}
