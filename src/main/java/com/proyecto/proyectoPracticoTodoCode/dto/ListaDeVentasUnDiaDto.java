package com.proyecto.proyectoPracticoTodoCode.dto;

import java.util.List;

public class ListaDeVentasUnDiaDto {
    private List<VentaDeUnDiaDto> listaVentasUnDia;

    private Integer cantidadVentas;

    private Double total;

    public ListaDeVentasUnDiaDto() {
    }

    public ListaDeVentasUnDiaDto(List<VentaDeUnDiaDto> listaVentasUnDia, Integer cantidadVentas, Double total) {
        this.listaVentasUnDia = listaVentasUnDia;
        this.cantidadVentas = cantidadVentas;
        this.total = total;
    }

    public List<VentaDeUnDiaDto> getListaVentasUnDia() {
        return listaVentasUnDia;
    }

    public void setListaVentasUnDia(List<VentaDeUnDiaDto> listaVentasUnDia) {
        this.listaVentasUnDia = listaVentasUnDia;
    }

    public Integer getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(Integer cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
