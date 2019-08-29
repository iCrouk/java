Public abstract class Empleado{

	private	String nombre;
	private String apellido;
	private String tlfno;
	private String direcc;
	private String e-mail;

	Empleado(String nombre, String apellido, String tfno, String direcc, String e-mail){
		this.nombre=nombre;
		this.apellido=apellido;
		this.tfno=tfno;
		this.direcc=direcc;
		this.e-mail=e-mail;
	}
	
	abstract void validarPass(int  Rpassword);
	
	void verDatos(){
		System.out.println("Nombre:"+nombre);
		System.out.println("Apellido:"+apellido);
		System.out.println("telefono:"+tfno);
		System.out.println("Direccion:"+direcc);
		System.out.println("E-mail:"+e-mail);
	}
}

Final class Externo extends Empleado{
	
	final int password=76767;
	String nombreContrata;
	
	Externo(String nombre, String apellido, String tfno, String direcc, String e-mail, String  nombreContarta){
		super(nombre, apellido, tfno, direcc, e-mail);
		this.nombreContrata=nombreContrata;
	}
	
	void validarPass(int Rpassword){
		if(Rpassword==password){
			verDatos();
		}
	}
	
}

import java.util.*;
Final class Interno extends Empleado{
		
	int password;
	string Codigo;
	random r=new random;

	Interno(String nombre, String apellido, String tfno, String direcc, String e-mail, String Codigo){
		super(nombre, apellido, tfno, direcc, e-mail);
		this.Codigo=Codigo;
	}
	
	int encriptar(String codigo, String nombre) throws NumbreFormatException, ArithmeticException{
		
		String tabla[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P",
				"Q","R","S","T","U","V","W","X","Y","Z"};
		String Z=" ";
		For( int i=0; i<nombre.length();i++){
			For(int j=0;j<tabla.lenght; j++){
				if(String.valueOf(nombre.charAt(i)).equalsIgnoreCase(tabla[j]){
					z=z+Integer.toString(j+1);
				}
			}
		}
		
		int numero= Integer.parseInt(z);
		int cod= Integer.parseInt(codigo);
		password= int((numero*(r.Nextint()/r.Nextint())+cod)*100.5);
		return password;
	}
	
	void validarPass( int Rpassword){
		if(Rpassword==password){
			verDatos();
		}
	}
}

import java.io.*;
Class Usamos{
	static Empleado Dato(int d)trows IOException, NumbreFormatException, ArithmeticException{
	
		BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
		System.out,println("introduzca el nombre:");
		String nombre=leer.readLine();
		System.out,println("introduzca el apellido:");
		String apellido=leer.readLine();	
		System.out,println("introduzca el telefono:");
		String tfno=leer.readLine();
		System.out,println("introduzca el Direccion:");
		String direcc=leer.readLine();
		System.out,println("introduzca el e mail:");
		String e-mail=leer.readLine();
		If (d==1){
		//Interno
			System.out,println("introduzca el Codigo:");
			String Codigo=leer.readLine();
			Intreno MyInterno=new Interno(nombre,apellido,tfno,direcc,e-mail,codigo);
			myIntreno.encriptar(Codigo,nombre);
			return Myintreno;
		}else{
		//Externo
			System.out,println("introduzca el nombreContrata:");
			String nc=leer.readLine();
			Intreno MyExterno= new Externo(nombre,apellido,tfno,direcc,e-mail,nc);
			return MyExterno;
		}
	}
	
	public static Void main(String args[]){
		BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
		interno in=null;
		Externo ex=null;
		try{
			try{
				

		