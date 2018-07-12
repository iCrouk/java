package com.Proyecto1.POO;

public class Coche {
	
	private String modelo,marca;
	private int numeroRuedas,numeroPuertas,motor,peso;

	public Coche(String modelo, String marca, int numeroRuedas, int numeroPuertas, int motor, int peso) {
		// TODO Auto-generated constructor stub
		this.marca=marca;
		this.modelo=modelo;
		this.numeroRuedas=numeroRuedas;
		this.numeroPuertas=numeroPuertas;
		this.motor = motor;
		this.peso = peso;
	}
	
	public Coche() {
		// TODO Auto-generated constructor stub
		this.marca="FORD";
		this.modelo="FOCUS";
		this.numeroRuedas=4;
		this.numeroPuertas=5;
		this.motor = 1600;
		this.peso = 1324;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	public void setNumeroRuedas(int numeroRuedas) {
		this.numeroRuedas = numeroRuedas;
		if (this.numeroRuedas < 4) {this.numeroRuedas = 4;}
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	public int getMotor() {
		return motor;
	}

	public void setMotor(int motor) {
		this.motor = motor;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public void pintar() {
		
		System.out.println("Modelo: "+this.getModelo());
		System.out.println("Marca: "+this.getMarca());
		System.out.println("Num.Ruedas: "+this.getNumeroRuedas());
		System.out.println("Num.Puertas: "+this.getNumeroPuertas());
		System.out.println("Motor: "+this.getModelo());
		System.out.println("Peso: "+this.getPeso());
	}
	
	
	

}
