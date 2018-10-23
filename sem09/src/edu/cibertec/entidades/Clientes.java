package edu.cibertec.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Clientes implements Serializable {
	
	private int codigo;
	private String nombre;
	private String[] tipo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[] getTipo() {
		return tipo;
	}
	public void setTipo(String[] tipo) {
		this.tipo = tipo;
	}
	public Clientes(int codigo, String nombre, String[] tipo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	public Clientes() {
	
	}
	
	@Override
	
	public String toString(){
		
		return String.format("%d - %s. Tipos : %s", codigo, nombre, tipo);
		
	}

}
