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

	@Autowired
	private SucursalRepository sucursalRepository;

	public List<Sucursal> buscarPorPais(String pais) {
		return sucursalRepository.findByPaisSucursal(pais);
	}

	public List<Sucursal> obtenerTodasLasSucursales() {
		return sucursalRepository.findAll();
	}

	public Optional<Sucursal> obtenerSucursalPorId(Integer id) {
		return sucursalRepository.findById(id);
	}

	public Sucursal crearSucursal(SucursalDTO sucursalDTO) {
		Sucursal sucursal = convertirDtoASucursal(sucursalDTO);
		return sucursalRepository.save(sucursal);
	}

	public Sucursal actualizarSucursal(Integer id, SucursalDTO sucursalDTO) {
		Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
		if (optionalSucursal.isPresent()) {
			Sucursal sucursal = optionalSucursal.get();
			actualizarSucursalDesdeDto(sucursal, sucursalDTO);
			return sucursalRepository.save(sucursal);
		} else {
			throw new IllegalArgumentException("La sucursal con ID " + id + " no existe.");
		}
	}

	public void eliminarSucursal(Integer id) {
		sucursalRepository.deleteById(id);
	}

	private Sucursal convertirDtoASucursal(SucursalDTO sucursalDTO) {
		Sucursal sucursal = new Sucursal();
		sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
		return sucursal;
	}

	private void actualizarSucursalDesdeDto(Sucursal sucursal, SucursalDTO sucursalDTO) {
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
	}
}