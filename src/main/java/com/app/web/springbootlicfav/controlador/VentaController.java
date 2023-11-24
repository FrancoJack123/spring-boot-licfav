package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.entidad.Usuario;
import com.app.web.springbootlicfav.servicio.VentaServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LIC-FAV/Venta")
public class VentaController {

    @Autowired
    private VentaServicio ventaServicio;

    @GetMapping("")
    public String Index(
            Model model,
            HttpSession session
    ){
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("ventas", ventaServicio.ListarVentasUsuario(usuario.getCodUsua()));
        return "Venta/Index";
    }



}
