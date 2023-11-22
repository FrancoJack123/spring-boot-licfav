package com.app.web.springbootlicfav.servicio;

import com.app.web.springbootlicfav.entidad.Producto;
import com.app.web.springbootlicfav.entidad.Proveedor;
import com.app.web.springbootlicfav.repositorio.ProductoRepositorio;
import com.app.web.springbootlicfav.repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio {
    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    public List<Proveedor> ListarProveedores(){
        return proveedorRepositorio.findAll();
    }

    public Proveedor BuscarProveedor(Long codigo){
        return proveedorRepositorio.findById(codigo).get();
    }

    public void GuardarProveedor(Proveedor objeto){
        proveedorRepositorio.save(objeto);
    }

    public void EliminarProveedor(Long codigo){
        proveedorRepositorio.deleteById(codigo);
    }
}
