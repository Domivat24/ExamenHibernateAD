package org.iesabastos.dam.datos.ijg.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "etapa")
public class Etapa implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private byte netapa;
	private int km;
	private String salida;
	private String llegada;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "dorsal")
	private Ciclista ganador;

	@OneToMany(mappedBy = "etapaPuesta", cascade = CascadeType.DETACH)
	List<Llevar> llevars;


	public byte getNetapa() {
		return netapa;
	}

	public void setNetapa(byte netapa) {
		this.netapa = netapa;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}

	public Ciclista getGanador() {
		return ganador;
	}

	public void setGanador(Ciclista ganador) {
		this.ganador = ganador;
	}

	public Etapa() {
	}
}
