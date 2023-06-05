package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.domain.Sucursal;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO extends Sucursal {

	private String tipoSucursal;
	private static final List<String> paises = Arrays.asList("Alemania", "Belgica", "Croacia", "Dinamarca", "España",
			"Francia", "Irlanda", "Letonia", "Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia",
			"Grecia", "Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungria",
			"Italia", "Lituania", "Portugal", "Rumania");

	public SucursalDTO() {
	}

	public SucursalDTO(String nombreSucursal, String paisSucursal) {
	    super(nombreSucursal, paisSucursal);
	    asignarTipoSucursal(paisSucursal);
	}

	public String getTipoSucursal() {
		return tipoSucursal;
	}

	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	public static List<String> getPaises() {
		return paises;
	}
	
	public void asignarTipoSucursal(String pais) {
	    if (paises.contains(pais)) {
	        this.tipoSucursal = "UE";
	    } else {
	        this.tipoSucursal = "Fuera UE";
	    }
	}
}