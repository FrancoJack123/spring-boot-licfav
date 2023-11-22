package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.entidad.Proveedor;
import com.app.web.springbootlicfav.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/LIC-FAV/Proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("")
    public String Index(
            Model model
    ){
        model.addAttribute("proveedores", proveedorServicio.ListarProveedores());
        return "Proveedor/Index";
    }

    @GetMapping("/")
    public String Create(
            Model model
    ){
        model.addAttribute("proveedor", new Proveedor());
        return "Proveedor/Create";
    }

    @GetMapping("/{codigo}")
    public String Edit(
            @PathVariable Long codigo,
            Model model
    ){
        model.addAttribute("proveedor", proveedorServicio.BuscarProveedor(codigo));
        return "Proveedor/Edit";
    }

    @PostMapping("/")
    public String Save(
            @ModelAttribute Proveedor proveedor
    ){
        proveedorServicio.GuardarProveedor(proveedor);
        return "redirect:/LIC-FAV/Proveedor";
    }

    @PostMapping("")
    public String Delete(
            @RequestParam Long codigo,
            Model model
    ){
        proveedorServicio.EliminarProveedor(codigo);
        return "redirect:/LIC-FAV/Proveedor";
    }
}
