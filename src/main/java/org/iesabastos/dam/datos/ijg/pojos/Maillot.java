package org.iesabastos.dam.datos.ijg.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "maillot")
public class Maillot implements Serializable {
	@Id
	private String codigo;
	private String tipo;
	private String color;
	private int premio;
	@OneToMany(mappedBy = "maillot", cascade = CascadeType.DETACH)
	List<Llevar> llevars;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	public Maillot() {
	}
}
