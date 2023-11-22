package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.entidad.Categoria;
import com.app.web.springbootlicfav.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/LIC-FAV/Categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("")
    public String Index(
            Model model
    ){
        model.addAttribute("categorias", categoriaServicio.ListarCategoria());
        return "Categoria/Index";
    }

    @GetMapping("/")
    public String Create(
            Model model
    ){
        model.addAttribute("categoria", new Categoria());
        return "Categoria/Create";
    }

    @GetMapping("/{codigo}")
    public String Edit(
            @PathVariable Long codigo,
            Model model
    ){
        model.addAttribute("categoria", categoriaServicio.BuscarCategoria(codigo));
        return "Categoria/Edit";
    }

    @PostMapping("/")
    public String Save(
            @ModelAttribute Categoria categoria
    ){
        categoriaServicio.GuardarCategoria(categoria);
        return "redirect:/LIC-FAV/Categoria";
    }

    @PostMapping("")
    public String Delete(
            @RequestParam Long codigo,
            Model model
    ){
        categoriaServicio.EliminarCategoria(codigo);
        return "redirect:/LIC-FAV/Categoria";
    }
}
