package com.proyecto.proyectoPracticoTodoCode.dto;

public class ProductoVentaDto {
    private Long idProducto;
    private String nombre;
    private String marca;
    private Double costo;

    private Integer cantidad;

    public ProductoVentaDto() {
    }

    public ProductoVentaDto(Long idProducto, String nombre, String marca, Double costo, Integer cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
}
