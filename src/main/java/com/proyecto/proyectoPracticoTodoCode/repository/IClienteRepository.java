package com.proyecto.proyectoPracticoTodoCode.repository;

import com.proyecto.proyectoPracticoTodoCode.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
