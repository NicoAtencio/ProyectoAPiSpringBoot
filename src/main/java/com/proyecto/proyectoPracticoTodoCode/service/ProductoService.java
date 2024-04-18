package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.model.Producto;
import com.proyecto.proyectoPracticoTodoCode.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository repoProd;


    @Override
    public List<Producto> getProducts() {
        List<Producto> listaProductos =repoProd.findAll();
        return listaProductos;
    }

    @Override
    public Producto findProduct(Long id_producto) {
        Producto prod = repoProd.findById(id_producto).orElse(null);
        return prod;
    }

    @Override
    public void saveProduct(Producto prod) {
        repoProd.save(prod);
    }

    @Override
    public void deleteProduct(Long id_producto) {
        repoProd.deleteById(id_producto);
    }

    @Override
    public void editProduct(Producto prod) {
        this.saveProduct(prod);
    }

    @Override
    public List<Producto> getProductMinQuantity(int stockMaximo) {
        List<Producto> listaProductos = new ArrayList<>();
        List<Producto> todosLosProductos = this.getProducts();
        for (Producto prod : todosLosProductos) {
            if(prod.getCantidad_disponible() <= stockMaximo) {
                listaProductos.add(prod);
            }
        }
        return listaProductos;
    }


}
