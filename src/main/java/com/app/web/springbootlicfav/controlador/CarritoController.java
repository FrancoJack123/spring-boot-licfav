package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.entidad.DetalleVenta;
import com.app.web.springbootlicfav.entidad.Usuario;
import com.app.web.springbootlicfav.entidad.Venta;
import com.app.web.springbootlicfav.servicio.VentaServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/LIC-FAV/Carrito")
public class CarritoController {

    @Autowired
    private VentaServicio ventaServicio;

    @GetMapping("")
    public String Index(
        Model model,
        HttpSession session
    ){
        List<DetalleVenta> carrito = (List<DetalleVenta>) session.getAttribute("carrito");
        model.addAttribute("carrito", carrito);
        model.addAttribute("montoTotal", carrito.stream().mapToDouble(DetalleVenta::getMontoDetVenta).sum());
        return "Carrito/Index";
    }

    @PostMapping("/Eliminar")
    public String Eliminar(
            @RequestParam Long productoId,
            HttpSession session
    ){
        List<DetalleVenta> carrito = (List<DetalleVenta>) session.getAttribute("carrito");
        for (int i = 0; i < carrito.size(); i++){
            if (carrito.get(i).getProducto().getCodPro() == productoId){
                carrito.remove(carrito.get(i));
            }
        }
        return "redirect:/LIC-FAV/Carrito";
    }

    @PostMapping("/Comprar")
    public String Compra(
            HttpSession session
    ){
        List<DetalleVenta> carrito = (List<DetalleVenta>) session.getAttribute("carrito");
        Double monto = carrito.stream().mapToDouble(DetalleVenta::getMontoDetVenta).sum();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Venta venta = new Venta();
        carrito.forEach(detalle -> detalle.setVenta(venta));
        venta.setFchVen(new Date());
        venta.setMonto(monto);
        venta.setUsuario(usuario);
        venta.setDetalleVentaList(carrito);
        ventaServicio.GuardarVenta(venta);
        session.setAttribute("carrito", new ArrayList<DetalleVenta>());
        return "redirect:/LIC-FAV/Tienda";
    }
}
