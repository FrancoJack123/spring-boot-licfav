package com.app.web.springbootlicfav.controlador;

import com.app.web.springbootlicfav.entidad.Producto;
import com.app.web.springbootlicfav.servicio.CategoriaServicio;
import com.app.web.springbootlicfav.servicio.ProductoServicio;
import com.app.web.springbootlicfav.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/LIC-FAV/Producto")
public class ProductoController {

    @Value("${storage.location}")
    private String storageLocation;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ProveedorServicio proveedorServicio;

    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("")
    public String Index(
            Model model
    ){
        model.addAttribute("productos", productoServicio.ListarProducto());
        return "Producto/Index";
    }

    @GetMapping("/")
    public String Create(
            Model model
    ){
        model.addAttribute("producto", new Producto());
        model.addAttribute("proveedores", proveedorServicio.ListarProveedores());
        model.addAttribute("categorias", categoriaServicio.ListarCategoria());
        return "Producto/Create";
    }

    @GetMapping("/{codigo}")
    public String Edit(
            @PathVariable Long codigo,
            Model model
    ){
        model.addAttribute("producto", productoServicio.BuscarProducto(codigo));
        model.addAttribute("proveedores", proveedorServicio.ListarProveedores());
        model.addAttribute("categorias", categoriaServicio.ListarCategoria());
        return "Producto/Edit";
    }

    @PostMapping("/")
    public String Save(
            @ModelAttribute Producto producto,
            @RequestParam MultipartFile img
    ) throws IOException {
        if (!img.isEmpty()){
            byte[] bytes = img.getBytes();
            Files.write(Paths.get(storageLocation).resolve(img.getOriginalFilename()), bytes);
            producto.setFoto(img.getOriginalFilename());
        } else {
            Producto p = productoServicio.BuscarProducto(producto.getCodPro());
            producto.setFoto(p.getFoto());
        }

        productoServicio.GuardarProducto(producto);
        return "redirect:/LIC-FAV/Producto";
    }

    @PostMapping("/Desactivar")
    public String Desactivar(
            @RequestParam Long codigo,
            Model model
    ){
        productoServicio.DesactivarProducto(codigo);
        return "redirect:/LIC-FAV/Producto";
    }

    @PostMapping("/Activar")
    public String Activar(
            @RequestParam Long codigo,
            Model model
    ){
        productoServicio.ActivarProducto(codigo);
        return "redirect:/LIC-FAV/Producto";
    }
}
