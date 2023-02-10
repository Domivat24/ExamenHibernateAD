package org.iesabastos.dam.datos.ijg.pojos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "llevar")
public class Llevar implements Serializable {
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "dorsal")
	private Ciclista ciclistaRopa;

	@Id
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "netapa")
	private Etapa etapaPuesta;

	@Id
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "codigo")
	private Maillot maillot;

	public Llevar() {
	}

	public Ciclista getCiclistaRopa() {
		return ciclistaRopa;
	}

	public void setCiclistaRopa(Ciclista ciclistaRopa) {
		this.ciclistaRopa = ciclistaRopa;
	}

	public Etapa getEtapaPuesta() {
		return etapaPuesta;
	}

	public void setEtapaPuesta(Etapa etapaPuesta) {
		this.etapaPuesta = etapaPuesta;
	}

	public Maillot getMaillot() {
		return maillot;
	}

	public void setMaillot(Maillot maillot) {
		this.maillot = maillot;
	}
}
