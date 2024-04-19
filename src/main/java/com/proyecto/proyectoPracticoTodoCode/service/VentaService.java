package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.dto.ListaDeVentasUnDiaDto;
import com.proyecto.proyectoPracticoTodoCode.dto.ProductoVentaDto;
import com.proyecto.proyectoPracticoTodoCode.dto.VentaDeUnDiaDto;
import com.proyecto.proyectoPracticoTodoCode.model.DetalleVenta;
import com.proyecto.proyectoPracticoTodoCode.model.Producto;
import com.proyecto.proyectoPracticoTodoCode.model.Venta;
import com.proyecto.proyectoPracticoTodoCode.repository.IDetalleVentaRepository;
import com.proyecto.proyectoPracticoTodoCode.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVentaRepository repoVent;
    @Autowired
    private IDetalleVentaRepository repoDetalle;
    @Override
    public List<Venta> getSales() {
        List<Venta> ven = repoVent.findAll();
        return ven;
    }

    @Override
    public Venta saveSale(Venta ven) {
        Venta venConId = repoVent.save(ven);
        return venConId;
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

    @Override
    public List<ProductoVentaDto> productsSale(Long id_venta) {
        List<ProductoVentaDto> listaDto = new ArrayList<>();
        Venta ven = repoVent.findById(id_venta).orElse(null);
        for(DetalleVenta detalle : ven.getDetalleVentas()) {
            ProductoVentaDto dto = new ProductoVentaDto();
            dto.setIdProducto(detalle.getProducto().getCodigo_producto());
            dto.setNombre(detalle.getProducto().getNombre());
            dto.setMarca(detalle.getProducto().getMarca());
            dto.setCosto(detalle.getProducto().getCosto());
            dto.setCantidad(detalle.getCantidad());
            listaDto.add(dto);
        }
        return listaDto;
    }

    @Override
    public ListaDeVentasUnDiaDto ventasUnDia(LocalDate date) {
        List<Venta> listaVentas = repoVent.findByFechaVenta(date);
        List<VentaDeUnDiaDto> listaDtos = new ArrayList<>();
        double total = 0;
        for(Venta ven : listaVentas) {
            VentaDeUnDiaDto ventaDto = new VentaDeUnDiaDto();
            ventaDto.setIdVenta(ven.getCodigo_venta());
            ventaDto.setTotal(ven.getTotal());
            List<Producto> listaProductos = new ArrayList<>();
            for(DetalleVenta detalle : ven.getDetalleVentas()) {
                listaProductos.add(detalle.getProducto());
            }
            total += ven.getTotal();
            ventaDto.setListaProductos(listaProductos);
            listaDtos.add(ventaDto);
        }
        ListaDeVentasUnDiaDto listaUnDiaDeVentas = new ListaDeVentasUnDiaDto(listaDtos,listaDtos.size(),total);
        return listaUnDiaDeVentas;
    }


}
