package com.proyecto.proyectoPracticoTodoCode.controller;

import com.proyecto.proyectoPracticoTodoCode.model.DetalleVenta;
import com.proyecto.proyectoPracticoTodoCode.model.DetalleVentaId;
import com.proyecto.proyectoPracticoTodoCode.model.Producto;
import com.proyecto.proyectoPracticoTodoCode.model.Venta;
import com.proyecto.proyectoPracticoTodoCode.service.IDetalleVentaService;
import com.proyecto.proyectoPracticoTodoCode.service.IProductoService;
import com.proyecto.proyectoPracticoTodoCode.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService serviceVen;
    @Autowired
    IProductoService prodService;
    @Autowired
    IDetalleVentaService detalleService;


    @GetMapping("/ventas")
    public List<Venta> getSales() {
        return serviceVen.getSales();
    }

    @PostMapping("/ventas/crear")
    public  ResponseEntity<?> createSale(@RequestBody Venta ven) {
        if (ven.getDetalleVentas() == null || ven.getDetalleVentas().isEmpty()) {
            return ResponseEntity.badRequest().body("La venta debe tener al menos un detalle");
        }
        Venta ventaActual = serviceVen.saveSale(ven);
        double total = 0;
        for(DetalleVenta detalle: ven.getDetalleVentas()) {
            Producto producto = prodService.findProduct(detalle.getProducto().getCodigo_producto());
            if(producto != null && producto.getCantidad_disponible() >= detalle.getCantidad()) {
                total += producto.getCosto() * detalle.getCantidad();
                //Actualizar stock
                producto.setCantidad_disponible(producto.getCantidad_disponible() - detalle.getCantidad());
                prodService.saveProduct(producto);
                //Detalle venta
                detalle.setVenta(ventaActual);
                detalle.setProducto(producto);
                detalle.setId(new DetalleVentaId(ventaActual.getCodigo_venta(), producto.getCodigo_producto()));

                // Guardar en la tabla intermedia debe ocurrir después de asegurar que todos los datos necesarios están presentes y correctos
                detalleService.addDetalle(detalle);
            } else {
                return ResponseEntity.badRequest().body("Producto no disponible en cantidad requerida");
            }
        }
        ventaActual.setTotal(total);
        serviceVen.saveSale(ventaActual);
        return ResponseEntity.ok("Venta creada con éxito");
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
