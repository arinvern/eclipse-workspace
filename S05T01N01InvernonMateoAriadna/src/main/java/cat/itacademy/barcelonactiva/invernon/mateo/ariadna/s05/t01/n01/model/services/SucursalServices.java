package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.repository.SucursalRepository;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalServices {

    private final SucursalRepository sucursalRepository;

    @Autowired
    public SucursalServices(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public List<Sucursal> buscarPorPais(String pais) {
        return sucursalRepository.findByPaisSucursal(pais);
    }

    public List<Sucursal> obtenerTodasLasSucursales() {
        return sucursalRepository.findAll();
    }

    public SucursalDTO obtenerSucursalPorId(Integer id) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La sucursal con ID " + id + " no existe."));
        return convertirSucursalADto(sucursal);
    }

    public void crearSucursal(SucursalDTO sucursalDto) {
        Sucursal sucursal = convertirDtoASucursal(sucursalDto);
        sucursalRepository.save(sucursal);
    }

    public void actualizarSucursal(Integer id, SucursalDTO sucursalDto) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        if (optionalSucursal.isPresent()) {
            Sucursal sucursal = optionalSucursal.get();
            actualizarSucursalDesdeDto(sucursal, sucursalDto);
            sucursalRepository.save(sucursal);
        } else {
            throw new IllegalArgumentException("La sucursal con ID " + id + " no existe.");
        }
    }

    public void eliminarSucursal(Integer id) {
        sucursalRepository.deleteById(id);
    }

    private Sucursal convertirDtoASucursal(SucursalDTO sucursalDto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(sucursalDto.getPk_SucursalID());
        sucursal.setNomSucursal(sucursalDto.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDto.getPaisSucursal());
        return sucursal;
    }

    private void actualizarSucursalDesdeDto(Sucursal sucursal, SucursalDTO sucursalDto) {
        sucursal.setNomSucursal(sucursalDto.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDto.getPaisSucursal());
    }

    private SucursalDTO convertirSucursalADto(Sucursal sucursal) {
        SucursalDTO sucursalDto = new SucursalDTO();
        sucursalDto.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDto.setNomSucursal(sucursal.getNomSucursal());
        sucursalDto.setPaisSucursal(sucursal.getPaisSucursal());
        return sucursalDto;
    }
}