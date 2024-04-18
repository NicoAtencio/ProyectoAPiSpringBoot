package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> getProducts();

    public Producto findProduct(Long id_producto);
    public void saveProduct(Producto prod);
    public void deleteProduct(Long id_producto);
    public void editProduct(Producto prod);

    public List<Producto> getProductMinQuantity (int stockMaximo);

}
