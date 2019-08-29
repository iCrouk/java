
//22.ariketa

class Langilea{
	String izena, lanpostua, departamentua;
	Date jaiotzaData, altaData;
	int soldata;
	
	Langilea( String i, String l, String d, Date jd, Date ad, int s){
		izena=i:
		lanpostua=l;
		departamentua=d;
		jaiotzaData=jd;
		altaData=ad;
		soldata=s;
	}
	
	void Bistaratu(){
		System.out.println("izena: "+izena+"lanpostua: "+lanpostua+",departamentua: "+departamentua+",jaiotza data: "+jaiotzaData+",alta data: "+altaData+",soldata: "+soldata);
	}
}
	
class ZuzendaritzarakoPartaide extends Langilea{
	int plusa;
	int bulegoZenb; 
	int menpekoKop;

	ZuzendaritzarakoPartaidea( String i, String l, String d, Date jd, Date ad, int s,int pl, int bz, int mk){
		izena=i:
		lanpostua=l;
		departamentua=d;
		jaiotzaData=jd;
		altaData=ad;
		soldata=s;
		plusa=pl;
		bulegoZenb=bz;
		menpekoKop=mk;
	}

	void Bistaratu(){
		System.out.println("izena: "+izena+"lanpostua: "+lanpostua+",departamentua: "+departamentua+",jaiotza data: "+jaiotzaData+",alta data: "+altaData+",soldata: "+soldata+",pulusa"+plusa+",bulego zenbakia: "+bulegoZenb+",menpeko kopurua: "+menpekoKop);
	}
	
	batuSoldataOsoa(){
		retur (soldata+plusa)
	}
}

class Exekutatu{
	public static void main(String args[]){
		Date jd=new Date(77,8,1);
		Date ad=new Date(99,7,11);
		Langilea lang=new Langilea("mikel","programatzailea","informatika",jd, ad, 1500);
		Date jaiotza=new Date(73,2,15);
		Date alta=new Date(99,3,11); 
		ZuzendaritzakoPartaide zp=new Zuzendaritzako partaide("iñaki","departamentuburu","informatika",jaiotza,alta, 2500, 500, 10, 13);
		lang.bistaratu();
		zp.bistaratu();
	}
}