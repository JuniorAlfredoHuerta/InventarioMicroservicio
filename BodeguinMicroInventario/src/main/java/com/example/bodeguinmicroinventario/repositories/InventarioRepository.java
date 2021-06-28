package com.example.bodeguinmicroinventario.repositories;

import com.example.bodeguinmicroinventario.entities.CompositeKeyTP;
import com.example.bodeguinmicroinventario.entities.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findById(Long id);
    Optional<Inventario> findInventarioByBodegaidAndProductoid(String bodegaid, Long productoid);
    //Optional<Inventario> findbybodegaidandproductoid(String bodegaid,Long productoid);
    //List<Inventario> findbyBodegaid(String bodegaid);
}
