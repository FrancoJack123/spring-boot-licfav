package com.app.web.springbootlicfav.servicio;

import com.app.web.springbootlicfav.entidad.Categoria;
import com.app.web.springbootlicfav.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> ListarCategoria(){
        return categoriaRepositorio.findAll();
    }

    public Categoria BuscarCategoria(Long codigo){
        return categoriaRepositorio.findById(codigo).get();
    }

    public void GuardarCategoria(Categoria objeto){
        categoriaRepositorio.save(objeto);
    }

    public void EliminarCategoria(Long codigo){
        categoriaRepositorio.deleteById(codigo);
    }
}
