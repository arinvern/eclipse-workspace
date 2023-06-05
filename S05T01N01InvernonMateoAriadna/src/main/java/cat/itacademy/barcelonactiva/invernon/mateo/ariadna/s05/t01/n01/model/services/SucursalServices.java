package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.services;

import org.springframework.beans.BeanUtils;
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

    public void crearSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    public void actualizarSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    public void eliminarSucursal(Integer id) {
        sucursalRepository.deleteById(id);
    }

    public void actualizarSucursalDesdeDto(Sucursal sucursal, SucursalDTO sucursalDto) {
        BeanUtils.copyProperties(sucursalDto, sucursal);
    }

    private SucursalDTO convertirSucursalADto(Sucursal sucursal) {
        SucursalDTO sucursalDto = new SucursalDTO();
        sucursalDto.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDto.setNombreSucursal(sucursal.getNombreSucursal());
        sucursalDto.setPaisSucursal(sucursal.getPaisSucursal());
        return sucursalDto;
    }
}