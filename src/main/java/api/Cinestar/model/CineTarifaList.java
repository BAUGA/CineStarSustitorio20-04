package api.Cinestar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CineTarifaList {
	@Id
	private String DiasSemana;
	private String precio;
	public String getDiasSemana() {
		return DiasSemana;
	}
	public void setDiasSemana(String diasSemana) {
		DiasSemana = diasSemana;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	

}
