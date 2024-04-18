package com.proyecto.proyectoPracticoTodoCode.repository;

import com.proyecto.proyectoPracticoTodoCode.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
