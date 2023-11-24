package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.entidad.DetalleVenta;
import com.app.web.springbootlicfav.entidad.Producto;
import com.app.web.springbootlicfav.servicio.ProductoServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/LIC-FAV/Tienda")
public class TiendaController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("")
    public String Index(
            Model model,
            HttpSession session
    ) {
        if (session.getAttribute("carrito") == null) {
            session.setAttribute("carrito", new ArrayList<DetalleVenta>());
        }

        model.addAttribute("tienda", productoServicio.ListarProducto());
        return "Tienda/Index";
    }

    @PostMapping("/AgregarCarrito")
    public String AgregarCarrito(
            @RequestParam Integer cantidad,
            @RequestParam Long productoId,
            Model model,
            HttpSession session
    ) {

        Producto producto = productoServicio.BuscarProducto(productoId);
        List<DetalleVenta> carrito = (List<DetalleVenta>) session.getAttribute("carrito");

        boolean esta = false;
        for (int i = 0; i < carrito.size(); i++){
            if (carrito.get(i).getProducto().getCodPro() == productoId){
                carrito.get(i).setCantDetVenta(carrito.get(i).getCantDetVenta() + cantidad);
                carrito.get(i).setMontoDetVenta(carrito.get(i).getCantDetVenta() * carrito.get(i).getPreDetVenta());
                esta = true;
            }
        }

        if (!esta){
            carrito.add(new DetalleVenta(cantidad, producto.getPrePro(), (cantidad * producto.getPrePro()), producto));
        }

        session.setAttribute("carrito", carrito);

        return "redirect:/LIC-FAV/Tienda";
    }
}
