package com.Proiecto1.Matrices;

public class MatricesBidim {

	public static void main (String[] args) {
		
		int [][] arreglobi = new int[5][5];
		
		arreglobi[0][0] = 1; 
		arreglobi[0][1] = 10;
		arreglobi[0][2] = 100;
		arreglobi[0][3] = 1000;
		arreglobi[0][4] = 10000;
		
		arreglobi[1][0] = 20000; 
		arreglobi[1][1] = 2000;
		arreglobi[1][2] = 200;
		arreglobi[1][3] = 20;
		arreglobi[1][4] = 2;
		
		arreglobi[2][0] = 3; 
		arreglobi[2][1] = 30;
		arreglobi[2][2] = 300;
		arreglobi[2][3] = 3000;
		arreglobi[2][4] = 30000;
		
		arreglobi[3][0] = 40000; 
		arreglobi[3][1] = 4000;
		arreglobi[3][2] = 400;
		arreglobi[3][3] = 40;
		arreglobi[3][4] = 4;
		
		arreglobi[4][0] = 1; 
		arreglobi[4][1] = 1;
		arreglobi[4][2] = 1;
		arreglobi[4][3] = 1;
		arreglobi[4][4] = 1;
		
		for(int i=0;i<arreglobi.length;i++) {
			System.out.println();
			for(int j=0;j<arreglobi.length;j++) {
		
					System.out.print(arreglobi[i][j]+"  ");
			}
		}
	}
}
