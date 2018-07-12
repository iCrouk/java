package com.Proiecto1.Matrices;

import java.util.Arrays;


public class Matrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] matriz1 = {1,6,78,4,78,8,17,38,19};
		
		String [] matriz2= new String[6];
		
		matriz2[0] = "iker";
		matriz2[1] = "Ane";
		matriz2[2] = "Fer";
		matriz2[3] = "Maika";
		matriz2[4] = "Txeter";
		matriz2[5] = "Arane";
		
		
		//Recorrer
		Arrays.sort(matriz1);
		for (int i=0;i<matriz1.length;i++) {
			System.out.println(matriz1[i]);
		}
		Arrays.sort(matriz2);
		for(String elemento:matriz2) {
			System.out.println(elemento);
		}
	}

}
