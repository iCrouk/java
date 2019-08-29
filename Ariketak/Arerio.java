
//21.ariketa.
	
class Arerio{
	int armak;
	
	void Eraso(){
		System.out.println("Aliena Erasoan...");
	}
	
	void Eraso(int armak){
		this.armak=armak;
		System.out.println("Aliena "+this.armak+" armekin erasotzen");
	}

}
	
class Alien{
	string kolorea;
	int energia;
	int agresibitatea;
	void Alien(){
		kolorea="berdea";
		energia=100;
		agresibitatea=15;
	}
	
	void Alien( string k, int e, int a){
		kolorea=k;
		energia=e;
		agresibitatea=a;
	}
	
	void aldatuDosia(){
		string dosia;
		if (agresibitatea<10){
			dosia="botillatxo txikia2;}
		else{
			if (agresibitatea<20 & agresibitatea>=10){
				dosia= "botilatxo ertaina;}
		else{
			dosia="botillatxo handia";}
		System.out.println("beharrezko dosia="+ dosia);
	}
	
	void eraso(){
		string mota;
		if (agresibitatea<10){
			mota="uspeldurak, eraso minimoa";}
		else{
			if(agresibitatea<20 & agresibitatea>=10){
				mota="2.mailako erasoa";}
		else{
			mota="eraso bortitza, larriki sauritua";}
		
	}
	
	void bistaratuMota(){
		System.out.println("Eraso mota="+mota);
	}
	
	public static void main(String args[]);{
		
		Alien A=new Alien();
		Arerio Ar= new Arerio();
		A.aldatuDosia();
		A.eraso();
		A.bistaratuMota();
		System.out.println( "Arerio baten metodoei dei egin ondoren");
		Ar.eraso(); 
		ar.eraso(300);
	}
}  		