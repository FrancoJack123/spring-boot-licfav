package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.servicio.ProductoServicio;
import com.app.web.springbootlicfav.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LIC-FAV/Tienda")
public class TiendaController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("")
    public String Index(
        Model model
    ){
        model.addAttribute("tienda", productoServicio.ListarProducto());
        return "Tienda/Index";
    }
}
