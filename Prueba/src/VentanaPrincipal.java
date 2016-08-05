import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextArea;
import dfgip.es.leerfichero.*;
import dfgip.es.conexiones.*;

public class VentanaPrincipal {

	private JFrame frame;

	//CheckBox
	private JCheckBox chckbxAvila,chckbxMallorca,chckbxIbiza,chckbxMenorca,chckbxCofex,chckbxCiudad_Real,chckbxCofaga,
	chckbxCuenca,chckbxJaen,chckbxCofarle,chckbxRiofarco,chckbxCofaran,chckbxNafarco,chckbxCofas,chckbxCofarca,chckbxCofano,chckbxSocofasa
	,chckbxCofarte,chckbxCTalaverano,chckbxZacofarva,chckbxVascofar,chckbxAragofar,chckbxMelilla;
	//Botones
	private JButton btnZip,btnBorrar,btnTodo;
	//ArrayList
	private ArrayList <String> CoopActivas;
	
	private String dia,mes,ano;
	private JLabel lblCooperativas;
	private JTextField txtAño,txtMes,txtDia;
	private TextArea txtAAcciones;
	
	final String cabeceraDirectorio="e:/Diarios/Farmadata/"; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
					window.frame.setTitle("Compresor de Farmadata");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}
	/***
	 * Funcion que inicializa la fecha
	 */
	public void setfecha(String vdia, String vmes, String vano){
		this.dia = vdia;
		this.mes = vmes;
		this.ano = vano;		
	}
	
	public String getfecha(){
		return this.ano+this.mes+this.dia;
	}
	/***
	 * Lista de Cooperativas
	 * 
	 */
	public ArrayList<String> Cooperativas(){
		
		CoopActivas = new <String> ArrayList(); 
		
		if (chckbxAvila.isSelected()){
			CoopActivas.add(chckbxAvila.getText());}
		if (chckbxMallorca.isSelected()){
			CoopActivas.add(chckbxMallorca.getText());}
		if (chckbxIbiza.isSelected()){
			CoopActivas.add(chckbxIbiza.getText());}			
		if (chckbxMenorca.isSelected()){
			CoopActivas.add(chckbxMenorca.getText());}			
		if (chckbxCofex.isSelected()){
			CoopActivas.add(chckbxCofex.getText());}						
		if (chckbxCiudad_Real.isSelected()){
			CoopActivas.add(chckbxCiudad_Real.getText());}				
		if (chckbxCofaga.isSelected()){
			CoopActivas.add(chckbxCofaga.getText());}				
		if (chckbxCuenca.isSelected()){
			CoopActivas.add(chckbxCuenca.getText());}				
		if (chckbxJaen.isSelected()){
			CoopActivas.add(chckbxJaen.getText());}
		if (chckbxCofarle.isSelected()){
			CoopActivas.add(chckbxCofarle.getText());}				
		if (chckbxRiofarco.isSelected()){
			CoopActivas.add(chckbxRiofarco.getText());}				
		if (chckbxCofaran.isSelected()){
			CoopActivas.add(chckbxCofaran.getText());}				
		if (chckbxNafarco.isSelected()){
			CoopActivas.add(chckbxNafarco.getText());}				
		if (chckbxCofas.isSelected()){
			CoopActivas.add(chckbxCofas.getText());}				
		if (chckbxCofarca.isSelected()){
			CoopActivas.add(chckbxCofarca.getText());}				
		if (chckbxCofano.isSelected()){
			CoopActivas.add(chckbxCofano.getText());}			
		if (chckbxSocofasa.isSelected()){
			CoopActivas.add(chckbxSocofasa.getText());}				
		if (chckbxCofarte.isSelected()){
			CoopActivas.add(chckbxCofarte.getText());}				
		if (chckbxCTalaverano.isSelected()){
			CoopActivas.add(chckbxCTalaverano.getText());}				
		if (chckbxZacofarva.isSelected()){
			CoopActivas.add(chckbxZacofarva.getText());}				
		if (chckbxVascofar.isSelected()){
			CoopActivas.add(chckbxVascofar.getText());}			
		if (chckbxAragofar.isSelected()){
			CoopActivas.add(chckbxAragofar.getText());}
		if (chckbxMelilla.isSelected()){
			CoopActivas.add(chckbxMelilla.getText());}
		
		return CoopActivas;
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
	
	public void hacerZip(){
		
		//ArrayList <String> logs = new ArrayList();
		txtAAcciones.setText(null);
		for (int i=0; i<this.Cooperativas().size();i++){
			boolean imprimir = false; 
			//String vDirectorio = "e:/Diarios/Farmadata/"+this.Cooperativas().get(i);
			String vDirectorio = cabeceraDirectorio+this.Cooperativas().get(i);
			
			File file = new File(vDirectorio);
			String ficheros[] = file.list();
			if (ficheros == null) {
				System.out.println(vDirectorio+"	-->Esta vacio");
			}else{
				ArrayList <String> paraComprimir = new ArrayList();
				//System.out.println(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4)+" --> "+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4)));
				String fichero1 = "DSB0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.TXT";
				String fichero2 = "ESW0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.TXT";
				String fichero3 = "ESW0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-P.TXT";
				String ficheroComp = "ESW0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.ZIP";
				//String paraMover="";
				
				for (int x=0;x<ficheros.length;x++){
					//System.out.println("-- "+ficheros[x]);
					if (ficheros[x].equalsIgnoreCase(fichero1) | ficheros[x].equalsIgnoreCase(fichero2) | ficheros[x].equalsIgnoreCase(fichero3)){
						paraComprimir.add(ficheros[x]);
						imprimir= true;
					}
				}//endfor
				
				if (imprimir == true){
					//hacer el zip
					txtAAcciones.setText(txtAAcciones.getText()+vDirectorio+ "--> Contiene ficheros para hacer Zip\n");
					this.crearZip(vDirectorio, paraComprimir, ficheroComp);
					txtAAcciones.setText(txtAAcciones.getText()+"ZIPPED!\n");
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
				}else{
					txtAAcciones.setText(txtAAcciones.getText()+vDirectorio+ "--> No contiene ficheros para hacer Zip\n");
					System.out.println(vDirectorio+ "--> No contiene ficheros para hacer Zip");
				}
			}
		}
		txtAAcciones.setText(txtAAcciones.getText()+"\nCOMPROBAR TODOS LOS ZIP ANTES DE BORRAR LOS FICHEROS,GRACIAS\n");	
	}
	
	public String existeFicheroVentas(String pDirectorio, String pCooperativa, String pFecha){
		
		String fichero= null;
		
		this.setfecha(txtDia.getText(), txtMes.getText(), txtAño.getText());
		String ficheroABuscar = pFecha+"."+pCooperativa.substring(0,2)+pCooperativa.substring(3,4);
		System.out.println(pDirectorio+" --> Fichero Ventas:  "+ficheroABuscar);
		
		File file = new File(pDirectorio);
		String ficheros[] = file.list();
			
		for (int x=0;x<ficheros.length;x++){
			if (ficheros[x].equalsIgnoreCase(ficheroABuscar)){
				System.out.println("...Procesando Lineas, paciencia...");
				fichero = pDirectorio+"\\"+ficheroABuscar;
			}//endif
				
		}//end for
		
		return fichero;
	}
	
	public void crearBirckySanibrick(){
		
		for (int i=0; i<this.Cooperativas().size();i++){
			String ventas=	this.existeFicheroVentas(cabeceraDirectorio+this.Cooperativas().get(i), this.Cooperativas().get(i).toString(), this.getfecha());
			if (!ventas.isEmpty()){
				long inicio, fin;
				inicio = System.currentTimeMillis();
				LeerFichero lf= new LeerFichero();
				//lf.leerFichero(ventas);
				lf.insertarBatchFicheroVentasEnBD(ventas);
			
				conexionOracle co= new conexionOracle();
				//Escribir Bricks
				System.out.println("-- Generando fichero Bricks.....");
				String bricks = "ESW0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.TXT";
				int lineasBrick = lf.escribirFicheroBricks(cabeceraDirectorio+"\\"+this.Cooperativas().get(i).toString(),bricks , co.bricks());
				System.out.println("-- Generado fichero Bricks con "+lineasBrick+" lineas.");
				//Escribir SaniBricks
				System.out.println("-- Generadno fichero SaniBricks.....");
				String sanibrick = "DSB0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.TXT";
				int lineasSBrick = lf.escribirFicheroSanibricks(cabeceraDirectorio+"\\"+this.Cooperativas().get(i).toString(),sanibrick, co.sanibricks());
				System.out.println("-- Generado fichero SaniBricks con "+lineasSBrick+" lineas.");
				fin = System.currentTimeMillis() - inicio;
				System.out.println("-- Final (Tiempo en ejecucucion "+ fin+" milisegundos)");
				co.cerrarConexion();

			 }
			
		}//end for
		
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
            	System.out.println(pDirectorio+"\\"+pDatos.get(i));
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
	
	public void eliminarFicheros(){
		
		txtAAcciones.setText(null);
		for (int i=0; i<this.Cooperativas().size();i++){
			boolean imprimir = false; 
			//String vDirectorio = cabeceraDirectorio+this.Cooperativas().get(i);
			String vDirectorio = cabeceraDirectorio+this.Cooperativas().get(i);
			
			File file = new File(vDirectorio);
			String ficheros[] = file.list();
			if (ficheros == null) {
				txtAAcciones.setText(vDirectorio+"	-->Esta vacio"+"\n");
				System.out.println(vDirectorio+"	-->Esta vacio");
			}else{
				ArrayList <String> paraEliminar = new ArrayList();
				String fichero1 = "DSB0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.TXT";
				String fichero2 = "ESW0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.TXT";
				String fichero3 = "ESW0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-P.TXT";
				String ficheroComp = "ESW0"+comprobarCodigos(this.Cooperativas().get(i).toString().substring(0,2)+this.Cooperativas().get(i).toString().substring(3,4))+"D"+this.getfecha()+"-"+this.getfecha()+"-"+"001-S.ZIP";
				int numFicheros=0;
					
				for (int x=0;x<ficheros.length;x++){
					if ((ficheros[x].equalsIgnoreCase(fichero1))|(ficheros[x].equalsIgnoreCase(fichero2))|(ficheros[x].equalsIgnoreCase(fichero3))){
						paraEliminar.add(ficheros[x]);
						numFicheros++;
					}
					else if(ficheros[x].equalsIgnoreCase(ficheroComp)){
						numFicheros++;
					}
				}//end for
				
				if(numFicheros == 4){
					txtAAcciones.setText(txtAAcciones.getText()+"*"+this.Cooperativas().get(i)+"* \n");
					for (int z=0;z<paraEliminar.size();z++){
						File f = new File(vDirectorio+"\\"+paraEliminar.get(z));
						txtAAcciones.setText(txtAAcciones.getText()+" -- Eliminado-->"+paraEliminar.get(z)+"\n");
						//f.delete();
					}//endFor
				}//endif
				else if(numFicheros < 4){
					txtAAcciones.setText(txtAAcciones.getText()+"*"+this.Cooperativas().get(i)+"* \n");
					txtAAcciones.setText(txtAAcciones.getText()+" -- NO contiene el número de ficheros adecuado (= 4) para borrar REVISAR" +"\n");
				}//endif
				else if(numFicheros > 4){
					txtAAcciones.setText(txtAAcciones.getText()+"*"+this.Cooperativas().get(i)+"* \n");
					txtAAcciones.setText(txtAAcciones.getText()+" -- CONTIENE MAS  ficheros que el numero adecuado (= 4) para borrar REVISAR" +"\n");
				}//endif
					
			}//endif
		}//endfor
	}//end
				

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 781, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		chckbxAvila = new JCheckBox("05-2 Avila");
		chckbxAvila.setToolTipText("052");
		chckbxAvila.setBounds(8, 38, 113, 25);
		frame.getContentPane().add(chckbxAvila);
		
		chckbxMallorca = new JCheckBox("07-1 Apotecaris Mallorca");
		chckbxMallorca.setToolTipText("071");
		chckbxMallorca.setBounds(8, 68, 172, 25);
		frame.getContentPane().add(chckbxMallorca);
		
		chckbxIbiza = new JCheckBox("07-2 Ibiza");
		chckbxIbiza.setToolTipText("072");
		chckbxIbiza.setBounds(8, 98, 113, 25);
		frame.getContentPane().add(chckbxIbiza);
		
		chckbxMenorca = new JCheckBox("07-6 Menorca");
		chckbxMenorca.setToolTipText("076");
		chckbxMenorca.setBounds(8, 128, 113, 25);
		frame.getContentPane().add(chckbxMenorca);
		
		chckbxCofex = new JCheckBox("10-2 Cofex");
		chckbxCofex.setBounds(8, 158, 113, 25);
		frame.getContentPane().add(chckbxCofex);
		
		chckbxCiudad_Real = new JCheckBox("13-2 Ciudad Real");
		chckbxCiudad_Real.setBounds(8, 188, 138, 25);
		frame.getContentPane().add(chckbxCiudad_Real);
		
		chckbxCofaga = new JCheckBox("15-2 Cofaga");
		chckbxCofaga.setBounds(8, 218, 113, 25);
		frame.getContentPane().add(chckbxCofaga);
		
		chckbxCuenca = new JCheckBox("16-2 Cuenca");
		chckbxCuenca.setBounds(8, 248, 113, 25);
		frame.getContentPane().add(chckbxCuenca);
		
		chckbxJaen = new JCheckBox("23-2 Jaen");
		chckbxJaen.setBounds(8, 278, 113, 25);
		frame.getContentPane().add(chckbxJaen);
		
		chckbxCofarle = new JCheckBox("24-2 Cofarle");
		chckbxCofarle.setBounds(8, 308, 113, 25);
		frame.getContentPane().add(chckbxCofarle);
		
		chckbxRiofarco = new JCheckBox("26-2 Riofarco");
		chckbxRiofarco.setBounds(8, 338, 113, 25);
		frame.getContentPane().add(chckbxRiofarco);
		
		chckbxCofaran = new JCheckBox("29-2 Cofaran");
		chckbxCofaran.setBounds(8, 368, 113, 25);
		frame.getContentPane().add(chckbxCofaran);
		
		chckbxNafarco = new JCheckBox("31-2 Nafarco");
		chckbxNafarco.setBounds(190, 38, 113, 25);
		frame.getContentPane().add(chckbxNafarco);
		
		chckbxCofas = new JCheckBox("33-2 Cofas");
		chckbxCofas.setBounds(190, 68, 113, 25);
		frame.getContentPane().add(chckbxCofas);
		
		chckbxCofarca = new JCheckBox("35-2 Cofarca");
		chckbxCofarca.setBounds(190, 98, 113, 25);
		frame.getContentPane().add(chckbxCofarca);
		
		chckbxCofano = new JCheckBox("36-2 Cofano");
		chckbxCofano.setBounds(190, 128, 113, 25);
		frame.getContentPane().add(chckbxCofano);
		
		chckbxSocofasa = new JCheckBox("37-2 Socofasa");
		chckbxSocofasa.setBounds(190, 158, 113, 25);
		frame.getContentPane().add(chckbxSocofasa);
		
		chckbxCofarte = new JCheckBox("38-4 Cofarte");
		chckbxCofarte.setBounds(190, 188, 113, 25);
		frame.getContentPane().add(chckbxCofarte);
		
		chckbxCTalaverano = new JCheckBox("45-2 C Talaverano Olias");
		chckbxCTalaverano.setBounds(190, 218, 172, 25);
		frame.getContentPane().add(chckbxCTalaverano);
		
		chckbxZacofarva = new JCheckBox("47-2 Zacofarva");
		chckbxZacofarva.setBounds(190, 248, 156, 25);
		frame.getContentPane().add(chckbxZacofarva);
		
		chckbxVascofar = new JCheckBox("48-2 Vascofar");
		chckbxVascofar.setBounds(190, 278, 113, 25);
		frame.getContentPane().add(chckbxVascofar);
		
		chckbxAragofar = new JCheckBox("50-2 Aragofar");
		chckbxAragofar.setBounds(190, 308, 113, 25);
		frame.getContentPane().add(chckbxAragofar);
		
		chckbxMelilla = new JCheckBox("99-2 Melilla");
		chckbxMelilla.setBounds(190, 338, 113, 25);
		frame.getContentPane().add(chckbxMelilla);
		
		JButton btnSacarLogs = new JButton("Sacar LOGS");
		btnSacarLogs.setEnabled(false);
		btnSacarLogs.setBounds(525, 158, 123, 25);
		frame.getContentPane().add(btnSacarLogs);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int reply = JOptionPane.showConfirmDialog(btnBorrar, "Procederas al borrado de ficheros ¿Correcto?", "Borrar", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				 if (reply == JOptionPane.YES_OPTION) 
				    {
					 setfecha(txtDia.getText(), txtMes.getText(), txtAño.getText());
					 eliminarFicheros(); 
				    }
			}
		});
		btnBorrar.setForeground(Color.RED);
		btnBorrar.setBounds(395, 203, 123, 25);
		frame.getContentPane().add(btnBorrar);
		
		
		JButton btnTodo = new JButton("Todo/Ninguno");
		btnTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este es el boton de seleccionar todos los checkBox");
				
				if (chckbxAvila.isSelected()){
					chckbxAvila.setSelected(false);}else{chckbxAvila.setSelected(true);}
				if (chckbxMallorca.isSelected()){
					chckbxMallorca.setSelected(false);}else{chckbxMallorca.setSelected(true);}
				if (chckbxIbiza.isSelected()){
					chckbxIbiza.setSelected(false);}else{chckbxIbiza.setSelected(true);}				
				if (chckbxMenorca.isSelected()){
					chckbxMenorca.setSelected(false);}else{chckbxMenorca.setSelected(true);}				
				if (chckbxCofex.isSelected()){
					chckbxCofex.setSelected(false);}else{chckbxCofex.setSelected(true);}							
				if (chckbxCiudad_Real.isSelected()){
					chckbxCiudad_Real.setSelected(false);}else{chckbxCiudad_Real.setSelected(true);}				
				if (chckbxCofaga.isSelected()){
					chckbxCofaga.setSelected(false);}else{chckbxCofaga.setSelected(true);}				
				if (chckbxCuenca.isSelected()){
					chckbxCuenca.setSelected(false);}else{chckbxCuenca.setSelected(true);}				
				if (chckbxJaen.isSelected()){
					chckbxJaen.setSelected(false);}else{chckbxJaen.setSelected(true);}	
				if (chckbxCofarle.isSelected()){
					chckbxCofarle.setSelected(false);}else{chckbxCofarle.setSelected(true);}				
				if (chckbxRiofarco.isSelected()){
					chckbxRiofarco.setSelected(false);}else{chckbxRiofarco.setSelected(true);}				
				if (chckbxCofaran.isSelected()){
					chckbxCofaran.setSelected(false);}else{chckbxCofaran.setSelected(true);}				
				if (chckbxNafarco.isSelected()){
					chckbxNafarco.setSelected(false);}else{chckbxNafarco.setSelected(true);}				
				if (chckbxCofas.isSelected()){
					chckbxCofas.setSelected(false);}else{chckbxCofas.setSelected(true);}				
				if (chckbxCofarca.isSelected()){
					chckbxCofarca.setSelected(false);}else{chckbxCofarca.setSelected(true);}				
				if (chckbxCofano.isSelected()){
					chckbxCofano.setSelected(false);}else{chckbxCofano.setSelected(true);}				
				if (chckbxSocofasa.isSelected()){
					chckbxSocofasa.setSelected(false);}else{chckbxSocofasa.setSelected(true);}				
				if (chckbxCofarte.isSelected()){
					chckbxCofarte.setSelected(false);}else{chckbxCofarte.setSelected(true);}				
				if (chckbxCTalaverano.isSelected()){
					chckbxCTalaverano.setSelected(false);}else{chckbxCTalaverano.setSelected(true);}				
				if (chckbxZacofarva.isSelected()){
					chckbxZacofarva.setSelected(false);}else{chckbxZacofarva.setSelected(true);}				
				if (chckbxVascofar.isSelected()){
					chckbxVascofar.setSelected(false);}else{chckbxVascofar.setSelected(true);}				
				if (chckbxAragofar.isSelected()){
					chckbxAragofar.setSelected(false);}else{chckbxAragofar.setSelected(true);}
				if (chckbxMelilla.isSelected()){
					chckbxMelilla.setSelected(false);}else{chckbxMelilla.setSelected(true);}
			}
		});
		btnTodo.setBounds(177, 368, 131, 25);
		frame.getContentPane().add(btnTodo);
		
		btnZip = new JButton("ZIP!");
		btnZip.setForeground(Color.BLUE);
		btnZip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Boton ZIP!");
				//JOptionPane.showMessageDialog(null, "Fecha elegida-->Año: "+txtAño.getText()+" Mes: "+txtMes.getText()+" Dia: "+txtDia.getText());
				int reply = JOptionPane.showConfirmDialog(btnZip, "Fecha: ("+txtAño.getText()+"/"+txtMes.getText()+"/"+txtDia.getText()+")", "¿Fecha correcta?", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				 if (reply == JOptionPane.YES_OPTION) 
				    {
					 setfecha(txtDia.getText(), txtMes.getText(), txtAño.getText());
					 hacerZip();
					 
				    }
				
				//txtAcciones.setText("Fecha elegida-->Año: "+txtAño.getText()+" Mes: "+txtMes.getText()+" Dia: "+txtDia.getText());
				
			}
		});
		btnZip.setBounds(395, 158, 123, 25);
		frame.getContentPane().add(btnZip);
		
		lblCooperativas = new JLabel("Cooperativas");
		lblCooperativas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCooperativas.setBounds(12, 13, 271, 25);
		frame.getContentPane().add(lblCooperativas);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(370, 19, 13, 353);
		frame.getContentPane().add(separator);
		
		JLabel labelAño = new JLabel("A\u00F1o");
		labelAño.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelAño.setBounds(395, 49, 46, 25);
		frame.getContentPane().add(labelAño);
		
		JLabel labelMes = new JLabel("Mes");
		labelMes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelMes.setBounds(395, 72, 46, 25);
		frame.getContentPane().add(labelMes);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDia.setBounds(395, 96, 46, 25);
		frame.getContentPane().add(lblDia);
		
		txtAño = new JTextField();
		txtAño.setBounds(429, 52, 116, 22);
		frame.getContentPane().add(txtAño);
		txtAño.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(429, 75, 116, 22);
		frame.getContentPane().add(txtMes);
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		txtDia.setBounds(429, 99, 116, 22);
		frame.getContentPane().add(txtDia);
	
		JLabel lblyyyy = new JLabel("(yyyy)");
		lblyyyy.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblyyyy.setBounds(546, 49, 46, 25);
		frame.getContentPane().add(lblyyyy);
		
		JLabel lblmm = new JLabel("(mm)");
		lblmm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblmm.setBounds(546, 71, 46, 27);
		frame.getContentPane().add(lblmm);
		
		JLabel lbldd = new JLabel("(dd)");
		lbldd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldd.setBounds(546, 95, 46, 27);
		frame.getContentPane().add(lbldd);
		
		JButton btnLimpiar = new JButton("Limpiar Pantalla");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAño.setText(null);
				txtMes.setText(null);
				txtDia.setText(null);
				txtAAcciones.setText(null);
				txtAño.setFocusable(true);
			}
		});
		btnLimpiar.setBounds(525, 203, 123, 25);
		frame.getContentPane().add(btnLimpiar);
		
		txtAAcciones = new TextArea();
		txtAAcciones.setFont(null);
		txtAAcciones.setForeground(Color.RED);
		
		txtAAcciones.setBackground(Color.WHITE);
		txtAAcciones.setEditable(false);
		txtAAcciones.setBounds(8, 394, 743, 180);
		frame.getContentPane().add(txtAAcciones);
		
		JButton btnBrickYSanibrick = new JButton("Generar Brick y Sanibrick");
		btnBrickYSanibrick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton Generar Bricks y Sanibricks");
				 setfecha(txtDia.getText(), txtMes.getText(), txtAño.getText());
				 crearBirckySanibrick();
			}
		});
		btnBrickYSanibrick.setForeground(Color.BLUE);
		btnBrickYSanibrick.setBounds(395, 248, 253, 25);
		frame.getContentPane().add(btnBrickYSanibrick);
		
		
	}
}
