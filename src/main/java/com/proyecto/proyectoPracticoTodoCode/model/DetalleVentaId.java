package com.proyecto.proyectoPracticoTodoCode.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DetalleVentaId implements Serializable {
    private Long id_venta;
    private Long id_producto;

    public DetalleVentaId() {
    }

    public DetalleVentaId(Long id_venta, Long id_producto) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
    }

    public Long getId_venta() {
        return id_venta;
    }

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }
}
