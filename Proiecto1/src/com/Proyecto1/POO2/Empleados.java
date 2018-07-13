package com.Proyecto1.POO2;

import java.util.Date;
import java.util.GregorianCalendar;

class Empleados {

	private String nombre;
	private double sueldo;
	private Date fecha;
	
	public Empleados(String nombre, double sueldo,int dia, int mes, int agno) {
		
		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar g = new GregorianCalendar(agno,mes-1,dia);
		this.fecha =g.getTime();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void subirSueldo(double porcentaje) {
		sueldo = sueldo + sueldo*porcentaje/100;
	}
	
	public void pintar() {
		System.out.println("NOMBRE: "+this.getNombre());
		System.out.println("SUELDO: "+this.getSueldo());
		System.out.println("FECHA: "+this.getFecha());
	}
}
