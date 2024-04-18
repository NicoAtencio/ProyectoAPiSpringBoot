package com.proyecto.proyectoPracticoTodoCode.model;


import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @EmbeddedId
    private DetalleVentaId id = new DetalleVentaId();

    @ManyToOne
    @MapsId("id_venta")
    @JoinColumn(name="id_venta")
    private Venta venta;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private Integer cantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(DetalleVentaId id, Venta venta, Producto producto, Integer cantidad) {
        this.id = id;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetalleVentaId getId() {
        return id;
    }

    public void setId(DetalleVentaId id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
