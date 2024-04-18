package com.proyecto.proyectoPracticoTodoCode.controller;

import com.proyecto.proyectoPracticoTodoCode.model.DetalleVenta;
import com.proyecto.proyectoPracticoTodoCode.model.Producto;
import com.proyecto.proyectoPracticoTodoCode.model.Venta;
import com.proyecto.proyectoPracticoTodoCode.service.IProductoService;
import com.proyecto.proyectoPracticoTodoCode.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService serviceVen;
    @Autowired
    IProductoService prodService;

    @GetMapping("/ventas")
    public List<Venta> getSales() {
        return serviceVen.getSales();
    }

    @PostMapping("/ventas/crear")
    public String createSale(@RequestBody Venta ven) {
        if (ven.getDetalleVentas() == null || ven.getDetalleVentas().isEmpty()) {
            return "La venta debe tener al menos un detalle";
        }
        double total = 0;
        for(DetalleVenta detalle: ven.getDetalleVentas()) {
            Producto producto = prodService.findProduct(detalle.getProducto().getCodigo_producto());
            if(producto != null && producto.getCantidad_disponible() >= detalle.getCantidad()) {
                total += producto.getCosto() * detalle.getCantidad();
                //Actualizar stock
                producto.setCantidad_disponible(producto.getCantidad_disponible() - detalle.getCantidad());
                prodService.saveProduct(producto);
            } else {
                return "No se puede vendar mas de lo que tenes";
            }
        }
        ven.setTotal(total);
        serviceVen.saveSale(ven);
        return "Se creo con exito la venta";
    }

    @GetMapping("/ventas/{id_venta}")
    public Venta getSale(@PathVariable Long id_venta) {
        return serviceVen.findSale(id_venta);
    }

    @PutMapping("/ventas/editar/{id_venta}")
    public Venta editSale (@RequestBody Venta ven) {
        serviceVen.editSale(ven);
        Venta updateSale = serviceVen.findSale(ven.getCodigo_venta());
        return updateSale;
    }

    @DeleteMapping("/ventas/eliminar/{id_venta}")
    public String deleteSale(@PathVariable Long id_venta) {
        serviceVen.deleteSale(id_venta);
        return "La venta fue eliminada";
    }
}
