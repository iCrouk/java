package com.Proyecto1.POO2;
import java.util.*;
public class UsarEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated met
		/* -- Una Forma de Hacer -- 
		Empleados miEmleado1 = new Empleados("IKER",30000,1973,2,21);
		Empleados miEmleado2 = new Empleados("ANE",60000,1883,7,11);
		Empleados miEmleado3 = new Empleados("Martin",30000,2003,8,5);
		Empleados miEmleado4 = new Empleados("IKER",30000,1993,9,7);
		
		miEmleado1.pintar();
		miEmleado2.pintar();
		miEmleado3.pintar();
		miEmleado4.pintar();
		*/
		
		/*------------------------------------------------------------------------------------*/
		
		ArrayList<Empleados> misEmpleado = new ArrayList<Empleados>();
		
		misEmpleado.add(new Empleados("IKER",30000,1973,2,21));
		misEmpleado.add(new Empleados("ANE",60000,1883,7,11));
		misEmpleado.add(new Empleados("Martin",30000,2003,8,5));
		misEmpleado.add(new Empleados("IKER",30000,1993,9,7));
		
		Iterator<Empleados> it = misEmpleado.iterator();
		
		while(it.hasNext()){
			it.next().pintar();
		}
		
		
	}

}
