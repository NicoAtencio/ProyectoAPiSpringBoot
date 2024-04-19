package com.proyecto.proyectoPracticoTodoCode.repository;

import com.proyecto.proyectoPracticoTodoCode.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta,Long> {
    List<Venta> findByFechaVenta(LocalDate fechaVenta);
}
