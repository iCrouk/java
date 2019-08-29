
class Ekuazio2Maila{
	double a;
	double b;
	double c;
	double x1;
	double x2;
	Ekuazio2Maila(){}
	Ekuazio2Maila( double lehena, double bigarrena, double hirugarrena){
		a=lehena;
		b=bigarrena;
		c=hirugarrena;
	}
	void erroarenKalkuloa (double u, double v, double w ) {
		double d=0;
		d= (v*v)-(4*u*w);
	if (d<0){
		System.out.println("ekuazio honek ez du soluziorik");
		}
	else{
		x1= (-v-Math.sqrt(d))/(2*u);
		x2= (-v+Math.sqrt(d))/(2*u);
		}
	
	}
	
	void erroakDira( double x1, double x2){
		System.out.println("Erroak Dirade: "+" x1="+x1+" eta "+" x2="+x2);
	}
	
	public static void main (String [ ] args){
	 Ekuazio2Maila ek= new Ekuazio2Maila( );
	Ekuazio2Maila e2m= new Ekuazio2Maila(  Double.parseDouble (args[0]), Double.parseDouble (args[1]), Double.parseDouble (args[2]));
	ek.a= Double.parseDouble (args[0]);
	ek.b= Double.parseDouble (args[1]);
	ek.c= Double.parseDouble (args[2]);
	ek.erroarenKalkuloa (ek.a,ek.b,ek.c);
	ek.erroakDira(ek.x1,ek.x2);
	e2m.erroakDira(e2m.x1, e2m.x2)
	 }
}