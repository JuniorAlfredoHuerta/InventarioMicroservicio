package com.example.bodeguinmicroinventario.service;

import com.example.bodeguinmicroinventario.dto.Categoriadto;
import com.example.bodeguinmicroinventario.dto.CreateCategoriaDto;
import com.example.bodeguinmicroinventario.entities.Categoria;
import com.example.bodeguinmicroinventario.exceptions.ProductoNotFoundException;
import com.example.bodeguinmicroinventario.repositories.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CategoriaService {
    Categoriadto getCategoriaById(Long categoriaid) throws ProductoNotFoundException;
    Categoriadto createCategoria(CreateCategoriaDto createCategoriaDto) throws ProductoNotFoundException;
    List<Categoriadto> getCategorias() throws ProductoNotFoundException;

}