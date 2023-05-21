package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.domain.Sucursal;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO extends Sucursal {

	private String tipoSucursal;
	private static final List<String> paisos = Arrays.asList("Alemanya", "Bèlgica", "Croàcia", "Dinamarca", "Espanya",
			"França", "Irlanda", "Letònia", "Luxemburg", "Països Baixos", "Suècia", "Bulgària", "Eslovàquia", "Estònia",
			"Grècia", "Malta", "Polònia", "República Txeca", "Àustria", "Xipre", "Eslovènia", "Finlàndia", "Hongria",
			"Itàlia", "Lituània", "Portugal", "Romania");

	public SucursalDTO() {
	}

	public SucursalDTO(String nomSucursal, String paisSucursal, String tipoSucursal) {
		super(nomSucursal, paisSucursal);
		this.tipoSucursal = tipoSucursal;
	}

	public String getTipusSucursal() {
		return tipoSucursal;
	}

	public void setTipusSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	public static List<String> getPaïsos() {
		return paisos;
	}
}