 public class Autoa{
	int abiadura;
	int martxa;
	boolean argiak;
	String matrikula;
	
	Autoa ( int ab, int m, boolean ar, string mat){
		abiadura=ab;
		martxa= m;
		argiak= ar;
		matrikula= mat;
	}

	 void aldatuArgiak( ){
	
		if (argiak==true){
			argiak=true;
	}
		else{
			argiak= false;
		}
	}

	 void azeleratu(int a){
		abiadura =(a+abadura);
	}

	 void blaztatu (int a){
		balaztatu= (azeleratu-a);
	}
	
	void aldatuMartxa( int m){
		martxa= m;
	}

	public static void main(Srting [ ] argas){
		Autoa aut=new Autoa(75, 4, true, "2343 BZT");
		aut.aldatuArgiak( );
		aut.azelaratu(100);
		aut.balaztatu(45);
		aut.aldatatuMartxa(5);
		System.out.println (matrikula+" matrikuladun autoa "+abiaduara+"-ko abiaduran doa, "+martxa+".martxan eta argiak"+aldatuArgiak);
	}
	}
	
	