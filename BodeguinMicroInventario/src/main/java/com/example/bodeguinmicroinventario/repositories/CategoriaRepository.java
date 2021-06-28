package com.example.bodeguinmicroinventario.repositories;

import com.example.bodeguinmicroinventario.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findById(Long id);
}
