package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.entidad.Usuario;
import com.app.web.springbootlicfav.servicio.RolServicio;
import com.app.web.springbootlicfav.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/LIC-FAV/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private RolServicio rolServicio;

    @GetMapping("")
    public String Index(
        Model model
    ){
        model.addAttribute("usuarios", usuarioServicio.ListarUsuario());
        return "Usuario/Index";
    }

    @GetMapping("/")
    public String Create(
        Model model
    ){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolServicio.ListarRol());
        return "Usuario/Create";
    }

    @GetMapping("/{codigo}")
    public String Edit(
        @PathVariable Long codigo,
        Model model
    ){
        model.addAttribute("usuario", usuarioServicio.BuscarUsuario(codigo));
        model.addAttribute("roles", rolServicio.ListarRol());
        return "Usuario/Edit";
    }

    @PostMapping("/")
    public String Save(
        @ModelAttribute Usuario usuario
    ){
        usuarioServicio.GuardarUsuario(usuario);
        return "redirect:/LIC-FAV/Usuario";
    }

    @PostMapping("")
    public String Delete(
        @RequestParam Long codigo,
        Model model
    ){
        usuarioServicio.EliminarUsuario(codigo);
        return "redirect:/LIC-FAV/Usuario";
    }


}
