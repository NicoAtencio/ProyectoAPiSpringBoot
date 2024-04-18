package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.model.DetalleVenta;
import com.proyecto.proyectoPracticoTodoCode.repository.IDetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService implements IDetalleVentaService{
    @Autowired
    private IDetalleVentaRepository repoDet;
    @Override
    public void addDetalle(DetalleVenta detalle) {
        repoDet.save(detalle);
    }
}
