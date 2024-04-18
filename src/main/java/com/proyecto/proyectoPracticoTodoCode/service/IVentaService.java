package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.model.Venta;

import java.util.List;

public interface IVentaService {
    public List<Venta> getSales();

    public Venta saveSale(Venta ven);
    public Venta findSale(Long id_venta);
    public void editSale(Venta ven);

    public void deleteSale(Long id_venta);

}
