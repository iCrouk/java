
package com.Proiecto1.fechas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author icoranti
 *
 */
public class Fechas {
	static Calendar mycalendar;
	
	int dia_i,mes_i,ano_i;
	String dia_s,mes_s;
	
	public Fechas() {
		// TODO Auto-generated constructor stub
		//this.mycalendar = new GregorianCalendar().getInstance();
		//this.dia_i= mycalendar.DAY_OF_MONTH;
		}
	public static int esPrimo (int a) {
		int kont =0;
		for (int i=2; i<a; i++) {
			if (a % i == 0 && a!=i) {
				kont++;
				break;
			}
		}
		
		if (kont == 0) {
			return a;}
		else
			return 0;
	}
	
	public static boolean esPar (int a) {
		boolean resultado = false;
		if (a % 2 == 0) {
			resultado = true;
		}
		return resultado;
	}
		
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> aPrimos = new ArrayList<>();
		ArrayList<Integer> aPar = new ArrayList<>();
		ArrayList<Integer> aInpar = new ArrayList<>();
		for (int i=1; i<11;i++) {
			System.out.println("ingresa un numero");
			//int numero= Integer.parseInt(sc.nextLine());
			int numero= sc.nextInt();
			a1.add(numero);	
			if(esPrimo(numero)!=0) {aPrimos.add(numero);}
			if(esPar(numero)) {aPar.add(numero);}else{aInpar.add(numero);}
		}
		
		sc.close();
		Collections.sort(a1);
		Collections.sort(aPrimos);
		Collections.sort(aPar);
		Collections.sort(aInpar);
		System.out.println("tdo el array:"+a1);
		System.out.println("primo el array:"+aPrimos);
		System.out.println("Pares:"+aPar);
		System.out.println("Impares:"+aInpar+" Kantidad: "+aInpar.size());
		
		
	}
}
