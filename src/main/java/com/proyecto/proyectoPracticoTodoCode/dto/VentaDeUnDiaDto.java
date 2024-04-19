package com.proyecto.proyectoPracticoTodoCode.dto;

import com.proyecto.proyectoPracticoTodoCode.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class VentaDeUnDiaDto {
    private Long idVenta;
    private Double total;
    private List<Producto> listaProductos;

    public VentaDeUnDiaDto() {
    }

    public VentaDeUnDiaDto(Long idVenta, Double total, List<Producto> listaProductos) {
        this.idVenta = idVenta;
        this.total = total;
        this.listaProductos = listaProductos;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
