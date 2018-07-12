package com.Proyecto1.Areas;
import java.util.Scanner;
import javax.swing.*;

public class Areas {
	
	static double cuadrado(double a, double b) {
		return a*b;
	}
	
	static double triangulo (double base, double altura) {
		return base*altura/2;
	}
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escibe la opcion de calculo: \n1:Cuadrado \n2:Rectanculo \n3:Triangulo \n4:Circulo");
		int opcion = sc.nextInt();
		
		switch (opcion) {
		case 1:
			int lado =Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor del lado"));
			System.out.printf("%1.2f", cuadrado(lado,lado));	
			break;
		case 2:
			int lado1 =Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor del lado 1"));
			int lado2 =Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor del lado 2"));
			System.out.printf("%1.2f", cuadrado(lado1,lado2));
			break;
		case 3:
			int base =Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor de la base"));
			int altura =Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor de la altura"));
			System.out.println("El balor de la base es: "+base+"\ny el valor de la altura es: "+altura+"\n Esto da como resultado: -->"+ triangulo(base, altura)+"<--");
			break;
		case 4:
		}
		sc.close();
		
		
	}

}
