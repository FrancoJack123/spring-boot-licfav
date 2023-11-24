package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LIC-FAV")
public class LicFavController {

    @Autowired
    private VentaServicio ventaServicio;

}
