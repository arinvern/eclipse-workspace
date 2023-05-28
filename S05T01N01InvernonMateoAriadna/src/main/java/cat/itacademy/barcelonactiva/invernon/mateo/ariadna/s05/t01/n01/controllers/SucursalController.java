package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.services.SucursalServices;
import java.util.List;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    private final SucursalServices sucursalService;

    @Autowired
    public SucursalController(SucursalServices sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/getAll")
    public String listarSucursales(Model model) {
        List<Sucursal> sucursales = sucursalService.obtenerTodasLasSucursales();
        model.addAttribute("sucursales", sucursales);
        return "listarSucursales";
    }

    @PostMapping("/add")
    public String crearSucursal(@ModelAttribute("sucursal") SucursalDTO sucursalDto) {
        sucursalService.crearSucursal(sucursalDto);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioEditarSucursal(@PathVariable Integer id, Model model) {
        SucursalDTO sucursalDto = sucursalService.obtenerSucursalPorId(id);
        model.addAttribute("sucursal", sucursalDto);
        return "formularioEditarSucursal";
    }

    @PutMapping("/update/{id}")
    public String actualizarSucursal(@PathVariable Integer id, @ModelAttribute("sucursal") SucursalDTO sucursalDto) {
        sucursalService.actualizarSucursal(id, sucursalDto);
        return "redirect:/sucursales";
    }
  

    @DeleteMapping("/delete/{id}")
    public String eliminarSucursal(@PathVariable Integer id) {
        sucursalService.eliminarSucursal(id);
        return "redirect:/sucursales";
    }
    
    @GetMapping("/getOne/{id}")
    public String obtenerSucursal(@PathVariable Integer id, Model model) {
        SucursalDTO sucursalDto = sucursalService.obtenerSucursalPorId(id);
        model.addAttribute("sucursal", sucursalDto);
        return "detalleSucursal";
    }
    
   }