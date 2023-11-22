package com.app.web.springbootlicfav.servicio;

import com.app.web.springbootlicfav.entidad.Categoria;
import com.app.web.springbootlicfav.entidad.Producto;
import com.app.web.springbootlicfav.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> ListarProducto(){
        return productoRepositorio.findAll();
    }

    public Producto BuscarProducto(Long codigo){
        return productoRepositorio.findById(codigo).get();
    }

    public void GuardarProducto(Producto objeto){
        productoRepositorio.save(objeto);
    }

    public void DesactivarProducto(Long codigo){
        productoRepositorio.updateEstProToFalse(codigo);
    }

    public void ActivarProducto(Long codigo){
        productoRepositorio.updateEstProToTrue(codigo);
    }
}
