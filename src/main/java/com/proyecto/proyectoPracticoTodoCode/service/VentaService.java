package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.model.Venta;
import com.proyecto.proyectoPracticoTodoCode.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVentaRepository repoVent;
    @Override
    public List<Venta> getSales() {
        List<Venta> ven = repoVent.findAll();
        return ven;
    }

    @Override
    public void saveSale(Venta ven) {
        repoVent.save(ven);
    }
    @Override
    public Venta findSale(Long id_venta) {
        Venta ven = repoVent.findById(id_venta).orElse(null);
        return ven;
    }
    @Override
    public void editSale(Venta ven) {
        repoVent.save(ven);
    }
    @Override
    public void deleteSale(Long id_venta) {
        repoVent.deleteById(id_venta);
    }


}
