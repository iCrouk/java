package dfgip.es.leerfichero;

import java.io.*;
import java.sql.*;
import dfgip.es.conexiones.*;

public class LeerFichero {
	
	public void leerFichero(String vFile){
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;

	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (vFile);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         int contador = 0;
	         while((linea=br.readLine())!=null){
	            System.out.println("Fecha: 20"+linea.substring(0,6)+
	            		" Cooprativa: 0"+linea.substring(6,9)+
	            		" Articulo: "+linea.substring(9,16)+
	            		" Cantidad: "+linea.substring(61,67)+
	            		" BRICKS: "+linea.substring(73,78)+
	            		" SANIBRIKS: "+linea.substring(80,86));
	            contador++;
	         }
	         System.out.println("Num.Filas: "+contador);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	}
/*	
	public void insertarFicheroVentasEnBD(String vFile){
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;

	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (vFile);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         
	         //Conexion BD
	         conexionOracle co= new conexionOracle();
	         co.borrar_dfg_ventas_farmadata();
	         co.cerrarConexion();

	         // Lectura del fichero
	         String linea;
	         int contador = 0;
	         while((linea=br.readLine())!=null){
	            String v_fecha = "20"+linea.substring(0,6);
	            String v_coop = "0"+linea.substring(6,9);
	            String v_articulo = "000000"+linea.substring(9,16);
	            String v_cantidad = linea.substring(61,67);
	            String v_brick = linea.substring(73,78);
	            String v_sanibrick = linea.substring(80,86);
	            //insertar en la BD
	            co= new conexionOracle();
	            co.insertar_dfg_ventas_farmadata(v_fecha, v_coop, v_articulo, v_cantidad, v_brick, v_sanibrick);
	            contador++;
	            co.cerrarConexion();   
	         }
	         System.out.println("--Numero de lineas importadas = "+ contador);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	}
*/
	
	public void insertarBatchFicheroVentasEnBD(String vFile){
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;

	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (vFile);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         
	         //Conexion BD
	         conexionOracle co= new conexionOracle();
	         co.borrar_dfg_ventas_farmadata();
	         co.cerrarConexion();

	         // Lectura del fichero
	         String linea;
	         int contador = 0;
	         co = new conexionOracle();
	         co.insertarbatch_dfg_ventas_farmadata();
	         while((linea=br.readLine())!=null){
	            String v_fecha = "20"+linea.substring(0,6);
	            String v_coop = "0"+linea.substring(6,9);
	            String v_articulo = "000000"+linea.substring(9,16);
	            String v_cantidad = linea.substring(61,67);
	            String v_brick = linea.substring(73,78);
	            String v_sanibrick = linea.substring(80,86);
	            //insertarBATCH en la BD
	            co.addbatch_dfg_ventas_farmadata(v_fecha, v_coop, v_articulo, v_cantidad, v_brick, v_sanibrick);
	            contador++;  
	         }
	         co.ejecutarbacth();
	         //co.borrar_dfg_ventas_cofano();
	         co.UPDATE_dfg_ventas_farmadata();
	         co.cerrarConexion();  
	         System.out.println("--Numero de lineas importadas = "+ contador);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	}
	
	public int escribirFicheroBricks(String vruta, String vnombre,ResultSet vrs){
		int contador=0;
		try{ 
        	String ruta = vruta;
        	String nombre =vnombre;
        	//FileWriter fw = new FileWriter("C:\\Users\\icoranti\\Desktop\\Farmadata\\05-2 Avila\\IKERprueba2.txt");
        	FileWriter fw = new FileWriter(ruta+"\\"+nombre);
        	BufferedWriter bw = new BufferedWriter(fw);
        	
        	while(vrs.next()){
                  bw.write("\""+vrs.getString(2)+"\",,\"1\",\""+vrs.getString("COD_BRICK")+"\",,,\""+vrs.getString("ARTICULO")+"\",\"1\",\"1\",,"+vrs.getString(4)+",,,\""+vrs.getString(1)+"\"");
                  bw.newLine();
                  contador++;
            }
        	bw.close();
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return contador;
	}
	/***
	 * 
	 * @param vruta
	 * @param vnombre
	 * @param vrs
	 * @return contador
	 * Escribe el fichero de Sanibricks en el directorio que le toca.
	 */
	public int escribirFicheroSanibricks(String vruta, String vnombre,ResultSet vrs){
		int contador=0;
		try{
        	String ruta = vruta;
        	String nombre =vnombre;
        	//FileWriter fw = new FileWriter("C:\\Users\\icoranti\\Desktop\\Farmadata\\05-2 Avila\\IKERprueba2.txt");
        	FileWriter fw = new FileWriter(ruta+"\\"+nombre);
        	BufferedWriter bw = new BufferedWriter(fw);
        	
        	while(vrs.next()){
                  bw.write("\""+vrs.getString(2)+"\",,\"1\",\""+vrs.getString("COD_SANIBRICK")+"\",,,\""+vrs.getString("ARTICULO")+"\",\"1\",\"1\",,"+vrs.getString(4)+",,,\""+vrs.getString(1)+"\"");
                  bw.newLine();	
                  contador++;
            }
        	bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return contador;
	}


}
