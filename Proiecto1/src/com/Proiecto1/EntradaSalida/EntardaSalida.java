package com.Proiecto1.EntradaSalida;
import javax.swing.*;
public class EntardaSalida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre = JOptionPane.showInputDialog("Escribe tu nombre");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Itroduce tu edad"));
		
		System.out.println(nombre+" "+edad);
	}

}
