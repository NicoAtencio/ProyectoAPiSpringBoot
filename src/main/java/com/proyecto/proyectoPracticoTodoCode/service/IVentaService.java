package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.dto.ListaDeVentasUnDiaDto;
import com.proyecto.proyectoPracticoTodoCode.dto.ProductoVentaDto;
import com.proyecto.proyectoPracticoTodoCode.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public List<Venta> getSales();

    public Venta saveSale(Venta ven);
    public Venta findSale(Long id_venta);
    public void editSale(Venta ven);

    public void deleteSale(Long id_venta);

    public List<ProductoVentaDto> productsSale(Long id_venta);

    public ListaDeVentasUnDiaDto ventasUnDia(LocalDate date);

}
