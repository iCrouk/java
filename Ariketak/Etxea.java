
class Etxea{
	String srtHelbidea;
	boolean bAltzariak;
	boolean bTximinia;
	boolean bAteaitxita;
	boolean bTximiniaPiztuta;

 void Etxea( ){
	bAltzariak=true;
	bTximinia=true;
	bAteaitxita=false;
	TximiniaPiztuta= false;
	}
 void itxiSarraila( ){
	if( bAteaitxita== false){
		itxiSarraila=true;
	}
	else{
		System.out.println("serraial itxita zegoen");
	}
	}
 viod irekiSarraila( ){
	if ( bAteaitxita==true){
		irekizerraila=false;
	}
	else{
		System.out.println("serraial irekita dago");
	}
	}
 void piztuSua( ){
	if (tximiniaPiztuta==false){
		piztuSua=true;	
	}
	else{
		System.out.println("sua piztua dago");
	}
	}
 public static void main
	Etxea E=new etxea