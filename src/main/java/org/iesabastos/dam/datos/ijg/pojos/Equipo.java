package org.iesabastos.dam.datos.ijg.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {
	@Id
	private String nomeq;
	private String director;

	@OneToMany(mappedBy = "equipo", cascade = CascadeType.DETACH)
	private List<Ciclista> ciclistas;

	public String getNomeq() {
		return nomeq;
	}

	public void setNomeq(String nomeq) {
		this.nomeq = nomeq;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}

	public Equipo() {
	}
}
