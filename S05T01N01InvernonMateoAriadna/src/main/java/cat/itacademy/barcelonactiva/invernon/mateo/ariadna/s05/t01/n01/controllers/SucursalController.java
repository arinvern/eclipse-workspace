package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.services.SucursalServices;

@Controller
public class SucursalController {

    @Autowired
    private SucursalServices sucursalService;

    @GetMapping("/sucursales")
    public String listarSucursales(Model model) {
        List<Sucursal> sucursales = sucursalService.obtenerTodasLasSucursales();
        model.addAttribute("sucursales", sucursales);
        return "listarSucursales";
    }

    @PostMapping("/buscarPorPais")
    public String buscarPorPais(@RequestParam String pais, Model model) {
        List<Sucursal> sucursales = sucursalService.buscarPorPais(pais);
        model.addAttribute("sucursales", sucursales);
        return "listarSucursales";
    }

    @GetMapping("/formularioSucursal")
    public String mostrarFormularioCrearSucursal(Model model) {
        model.addAttribute("sucursal", new SucursalDTO());
        return "formularioCrearSucursal";
    }

    @PostMapping("/crearSucursal")
    public String crearSucursal(@ModelAttribute("sucursal") SucursalDTO sucursalDto) {
        sucursalService.crearSucursal(sucursalDto);
        return "redirect:/sucursales";
    }
}