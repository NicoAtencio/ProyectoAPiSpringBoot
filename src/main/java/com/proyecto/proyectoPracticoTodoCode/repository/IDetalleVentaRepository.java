package com.proyecto.proyectoPracticoTodoCode.repository;

import com.proyecto.proyectoPracticoTodoCode.model.DetalleVenta;
import com.proyecto.proyectoPracticoTodoCode.model.DetalleVentaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, DetalleVentaId> {
}
