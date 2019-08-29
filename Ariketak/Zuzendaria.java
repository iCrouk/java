
 class Zuzendaria{
	String izena;
	String abizena;
	String helbidea;
	String telefonoa;
	Zuzendaria ( String i, String a, String h, String t){
		izena=i;
		abizena=a;
		helbidea=h;
		telefonoa=t;
	}
	
	void agurtuBezeroa( ){
		System.out.println("kaixo! Ni"+ abizena+"jauna naiz, baina"+izena+"deitu nazakezu. Hoteleko zuzendaria nauzu eta zure esanetara naukazu edozertarako");
	}
}