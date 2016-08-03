package hacerZip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class zipMaker {
	
	private String dia;
	private String mes;
	private String ano;
	
	public void setfecha(String vdia, String vmes, String vano){
		this.dia = vdia;
		this.mes = vmes;
		this.ano = vano;		
	}
	
	public String getfecha(){
		//System.out.println(this.ano+this.mes+this.dia);
		return this.ano+this.mes+this.dia;
	}
	
	public ArrayList farmacias(){
		
		ArrayList <String> Coop = new <String> ArrayList();
		//Coop.add("04-2 Hermandad Almeriense");
		Coop.add("05-2 Avila");
		Coop.add("07-1 Apotecaris Mallorca");
		Coop.add("07-2 Ibiza");
		Coop.add("07-6 Menorca");
		Coop.add("10-2 Cofex");
		//Coop.add("11-2 Xefar");
		Coop.add("13-2 Ciudad Real");
		Coop.add("15-2 Cofaga");
		Coop.add("16-2 Cuenca");
		//Coop.add("18-2 Hefagra");
		Coop.add("23-2 Jaen");
		Coop.add("24-2 Cofarle");
		Coop.add("26-2 Riofarco");
		Coop.add("29-2 Cofaran");
		//Coop.add("31-2 Nafarco");
		Coop.add("33-2 Cofas");
		Coop.add("35-2 Cofarca");
		Coop.add("36-2 Cofano");
		Coop.add("37-2 Socofasa");
		Coop.add("38-4 Cofarte");
		Coop.add("45-2 C Talaverano Olias");
		Coop.add("47-2 Zacofarva");
		Coop.add("48-2 Vascofar");
		Coop.add("50-2 Aragofar");
		Coop.add("99-2 Melilla");
		return Coop;
	}
	
	public void crearZip (String pDirectorio, ArrayList<String> pDatos, String pFicheroZipName){
		
		byte[] buffer = new byte[1024];
		
		try{
			
			FileOutputStream fos = new FileOutputStream(pDirectorio+"\\"+pFicheroZipName);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		
    		for (int i=0;i<pDatos.size();i++){
    			ZipEntry ze= new ZipEntry(pDatos.get(i));
    			zos.putNextEntry(ze);
    			FileInputStream in = new FileInputStream(pDirectorio+"\\"+pDatos.get(i));
   	   
    			int len;
    			while ((len = in.read(buffer)) > 0) {
    				zos.write(buffer, 0, len);
    			}

    			in.close();
    		}
    		zos.closeEntry();
    		zos.close();
		}catch(Exception e){e.printStackTrace();}
	}
/*
	public void moverZip(String pDirectorio,String pFichero,String pFicheroZipName){
		
		try{
			ArrayList <String> paraComprimir = new ArrayList();
			ZipInputStream zis = new ZipInputStream(new FileInputStream(pDirectorio+"\\"+pFicheroZipName+".zip"));
			ZipEntry entrada;
			while (null != (entrada=zis.getNextEntry()) ){
			   System.out.println(entrada.getName());
			   paraComprimir.add(entrada.getName());
			   
			   FileOutputStream fos = new FileOutputStream(entrada.getName());
			   int leido;
			   byte [] buffer = new byte[1024];
			   while (0<(leido=zis.read(buffer))){
			      fos.write(buffer,0,leido);
			   }
			   fos.close();
			   zis.closeEntry();
			}
			zis.close();
			paraComprimir.add(pFichero);
			
			this.crearZip(pDirectorio, paraComprimir, "prueba052.zip");
			
		}catch(Exception e){e.printStackTrace();}
	}
	*/
	public void eliminarFicheros(String pDirectorio,ArrayList<String> pDatos){
		
		for (int i=0;i<pDatos.size();i++){
			File f = new File(pDirectorio+"\\"+pDatos.get(i));
			if(f.exists()){
				f.delete();
			}
		}
	} 
	
	public void escrituraFicherosLog(String pDirectorio, ArrayList<String> pDatos){
		FileWriter fichero = null;
        PrintWriter pw = null;
        
        ArrayList <String> logsFinal = new ArrayList();
        
        try{
            fichero = new FileWriter("c:/FarmadataLOG_"+this.getfecha()+".txt");
            pw = new PrintWriter(fichero);
 
            for (int i = 0; i < pDatos.size(); i++){
            	File ficherot = new File(pDirectorio+"\\"+pDatos.get(i));
            	//System.out.println(pDirectorio+"\\"+pDatos.get(i));
            	if (ficherot.exists()){
            		if (ficherot.length() == 0){
            			logsFinal.add("--033[31m"+pDatos.get(i)+" -- 033[31m"+ficherot.length()+" 033[31mKB");}
            		else{
            			logsFinal.add("--"+pDatos.get(i)+" -- "+ficherot.length()+" KB");
            		}
            	}else{
            		logsFinal.add(pDatos.get(i));
            	}
            }
             
            for(int i = 0; i < logsFinal.size(); i++){
            	pw.println(logsFinal.get(i));
            }
 
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	public String comprobarCodigos(String pCodigo){
		
		String codigo="";
		//Hermandad Almeriense
		if (pCodigo.equalsIgnoreCase("042")){
			codigo ="043";
		//Hefagra
		}else if(pCodigo.equalsIgnoreCase("182")){
			codigo ="183";
		//Jaen	
		}else if(pCodigo.equalsIgnoreCase("232")){
			codigo ="234";
		//Nafarco	
		}else if(pCodigo.equalsIgnoreCase("312")){
			codigo ="317";
		//Cofarca	
		}else if(pCodigo.equalsIgnoreCase("352")){
			codigo ="354";
		}else{
			codigo =pCodigo;
		}
		return codigo;
	}
	
	public void leerDirectorio(){
		
		ArrayList <String> logs = new ArrayList();
		
		for (int i=0; i<this.farmacias().size();i++){
			String vDirectorio = "e:/Diarios/Farmadata/"+this.farmacias().get(i);
			//System.out.println(vDirectorio);
			File file = new File(vDirectorio);
			String ficheros[] = file.list();
			if (ficheros == null) {
				System.out.println("Esta vacio");
			}else{
				ArrayList <String> paraComprimir = new ArrayList();
				//System.out.println(this.farmacias().get(i).toString().substring(0,2)+this.farmacias().get(i).toString().substring(3,4)+" --> "+comprobarCodigos(this.farmacias().get(i).toString().substring(0,2)+this.farmacias().get(i).toString().substring(3,4)));
				String fichero1 = "DSB0"+comprobarCodigos(this.farmacias().get(i).toString().substring(0,2)+this.farmacias().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.TXT";
				String fichero2 = "ESW0"+comprobarCodigos(this.farmacias().get(i).toString().substring(0,2)+this.farmacias().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.TXT";
				String fichero3 = "ESW0"+comprobarCodigos(this.farmacias().get(i).toString().substring(0,2)+this.farmacias().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-P.TXT";
				String ficheroComp = "ESW0"+comprobarCodigos(this.farmacias().get(i).toString().substring(0,2)+this.farmacias().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.ZIP";
				String paraMover="";
				
				for (int x=0;x<ficheros.length;x++){
					//System.out.println("-- "+ficheros[x]);
					if (ficheros[x].equalsIgnoreCase(fichero1) | ficheros[x].equalsIgnoreCase(fichero2) | ficheros[x].equalsIgnoreCase(fichero3)){
						paraComprimir.add(ficheros[x]);
					}else if(ficheros[x].equalsIgnoreCase(this.getfecha()+"."+this.farmacias().get(i).toString().substring(0,2)+this.farmacias().get(i).toString().substring(3,4))){
						paraMover = ficheros[x];
					}//endif
				}//endfor
				
				//hacer el zip
				this.crearZip(vDirectorio, paraComprimir, ficheroComp);
				//this.moverZip(vDirectorio, paraMover,this.farmacias().get(i).toString().substring(0,2)+this.farmacias().get(i).toString().substring(3,4));
				/*Elimar los que no hacen falta*/
				this.eliminarFicheros(vDirectorio, paraComprimir);
				
				System.out.println("--------------------------------INI-------------------------------------------");
				System.out.println(vDirectorio);
				System.out.println("---");
				System.out.println("-NOMBRE del zip:"+ficheroComp);
				System.out.println("--Ficheros:");
				System.out.println("---"+fichero1);
				System.out.println("---"+fichero2);
				System.out.println("---"+fichero3);
				System.out.println(" 						--> ZIPPED! <--");
				System.out.println("--------------------------------FIN--------------------------------------------");
				
				/*LOG*/
				/*
				logs.add("---------------------------------------------------------------------------");
				logs.add(vDirectorio);
				logs.add("---");
				logs.add(ficheroComp);
				logs.add("--Ficheros:");
				logs.add(fichero1);
				logs.add(fichero2);
				logs.add(fichero3);
				logs.add("                         --> ZIPPED! <--");
				logs.add("----------------------------------------------------------------------------");
				this.escrituraFicheros("e:/Diarios/Farmadata/"+this.farmacias().get(i), logs);	
				*/
				
			}
		}		
		//this.escrituraFicheros("e:/Diarios/Farmadata/"+this.farmacias().get(i), logs);		
	}
	
	public static void main(String[] args) {
		
		String pDia;
	    String pMes;
	    String pAno;
		System.out.println ("Empezamos el programa");
        System.out.println ("Por favor el DIA por teclado:");
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        pDia = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        System.out.println ("Por favor introduzca el MES por teclado:");
        pMes = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        System.out.println ("Por favor introduzca el AÑO por teclado:");
        pAno = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        System.out.println ("-----------------------------------------");
        System.out.println ("-- Dia:"+pDia+" Mes:"+pMes+" Año:"+pAno+" --");
        System.out.println ("-----------------------------------------");
        System.out.println ("Si es correcta la Fecha introduzca S para continuar, de lo contrario N");
        String hacer = entradaEscaner.nextLine ();
        if (hacer.equalsIgnoreCase("S")){
        	System.out.println("hacermos el zip de  todos directorios.");
        	zipMaker zp = new  zipMaker();
        	zp.setfecha(pDia,pMes,pAno);
        	zp.leerDirectorio();
        	}//endif
        
	    }
}
