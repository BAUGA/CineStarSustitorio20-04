package api.Cinestar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class CinePeliculaList {
	@Id
	private String Titulo;
	private String Horarios;
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getHorarios() {
		return Horarios;
	}
	public void setHorarios(String horarios) {
		Horarios = horarios;
	}

}
