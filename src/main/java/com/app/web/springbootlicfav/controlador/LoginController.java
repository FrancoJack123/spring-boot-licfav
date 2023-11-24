package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.entidad.Usuario;
import com.app.web.springbootlicfav.servicio.UsuarioServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({"","/"})
    public String Login(

    ){
      return "Login/Login";
    };

    @PostMapping({"","/"})
    public String Login(
        @RequestParam String user,
        @RequestParam String password,
        HttpSession session
    ){
        Usuario usuario = usuarioServicio.Login(user, password);

        if (usuario != null){
            session.setAttribute("usuario", usuario);

            if (usuario.getRol().getCodRol() == 1)
                return "redirect:/LIC-FAV/Usuario";
            else
                return "redirect:/LIC-FAV/Tienda";

        } else {
            return "redirect:/";
        }

    };

    @GetMapping("/Register")
    public String Register(
        Model model
    ){
        model.addAttribute("usuario", new Usuario());
        return "Login/Register";
    };

    @PostMapping("/Register")
    public String Register(
            @ModelAttribute Usuario usuario,
            HttpSession session
    ){
        usuarioServicio.GuardarUsuario(usuario);
        session.setAttribute("usuario", usuario);

        return "redirect:/LIC-FAV/Tienda";
    };

    @GetMapping("/Logout")
    public String Logout(
        HttpSession session
    ){
        session.removeAttribute("usuario");
        session.removeAttribute("carrito");
        return "redirect:/";
    };
}
