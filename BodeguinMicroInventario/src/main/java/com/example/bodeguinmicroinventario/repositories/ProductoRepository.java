package com.example.bodeguinmicroinventario.repositories;

import com.example.bodeguinmicroinventario.entities.Categoria;
import com.example.bodeguinmicroinventario.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    Optional<Producto> findById(Long id);
    Optional<Producto> findByNombre(String nombre);
    Optional<Producto> findByCategoria(Long categoria);
    //Optional<Producto> findBystock(Integer stock);
}
