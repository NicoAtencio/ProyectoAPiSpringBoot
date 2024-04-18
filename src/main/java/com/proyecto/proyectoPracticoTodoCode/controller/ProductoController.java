package com.proyecto.proyectoPracticoTodoCode.controller;

import com.proyecto.proyectoPracticoTodoCode.model.Producto;
import com.proyecto.proyectoPracticoTodoCode.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService prodService;

    @GetMapping("/productos")
    public List<Producto> getProducts() {
        return prodService.getProducts();
    }

    @GetMapping("/productos/{id_producto}")
    public Producto findProduct(@PathVariable Long id_producto) {
        return prodService.findProduct(id_producto);
    }

    @PostMapping("/productos/crear")
    public String createProduct(@RequestBody Producto prod) {
        prodService.saveProduct(prod);
        return "Se creo con exito el producto";
    }
    @DeleteMapping("/productos/{id_producto}")
    public String deleteProduct(@PathVariable Long id_producto) {
        prodService.deleteProduct(id_producto);
        return "Producto eliminado con exito";
    }

    @PutMapping("/productos/editar")
    public Producto editProduct(@RequestBody Producto prod) {
        prodService.editProduct(prod);
        return prodService.findProduct(prod.getCodigo_producto());
    }

    @GetMapping("productos/cantidadmaxima/{stock}")
    public List<Producto> getProductMinQuantity(@PathVariable int stock) {
        return prodService.getProductMinQuantity(stock);
    }
}
