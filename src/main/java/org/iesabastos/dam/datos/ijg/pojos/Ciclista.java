package org.iesabastos.dam.datos.ijg.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ciclista")
public class Ciclista implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private byte dorsal;
	private String nombre;
	private Date fechaNac;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "nomeq")
	private Equipo equipo;

	@OneToMany(mappedBy = "ciclistaRopa", cascade = CascadeType.DETACH)
	List<Llevar> llevars;

	public List<Llevar> getLlevars() {
		return llevars;
	}

	public void setLlevars(List<Llevar> llevars) {
		this.llevars = llevars;
	}

	@OneToMany(mappedBy = "ganador", cascade = CascadeType.DETACH)
	List<Etapa> etapasGanadas;

	public short getDorsal() {
		return dorsal;
	}

	public void setDorsal(byte dorsal) {
		this.dorsal = dorsal;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public List<Etapa> getEtapasGanadas() {
		return etapasGanadas;
	}

	public void setEtapasGanadas(List<Etapa> etapasGanadas) {
		this.etapasGanadas = etapasGanadas;
	}

	public Ciclista() {
	}
}
