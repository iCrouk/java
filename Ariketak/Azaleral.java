
//23.Ariketa
	
class Printzipala{
	int dim1;
	int dim2;
	
	void kalkulatuAzalera(){}
}
class karratua extends Printzipala{
	
	karratua(int d){
		dim1=d;
		dim2=d;
	}
	
	void kalkulatuAzalera(){
		System.out.println("karratuaren azalera= "+dim1*dim2);
	}
}	
class LaukiZuzena extends Printzipala{
	
	LaukiZuzena(int d1, int d2){
		dim1=d1;
		dim2=d2;
	}
	
	void kalkulatuAzalera(){
		System.out.println("lauki-zuzenaren azalera= "+dim *dim2);
	}
}	
class Erronboa extends Printzipala{
	Erronboa(int d1, int d2){
		dim1=d1;
		dim2=d2;
	}
	void kalkulatuAzalera(){
		System.out.println("karratuaren Erronboaren= "+((dim1*dim2)/2));
	}
}
class Hirukia extends Printzipala{
	Hirukia(int d1, int d2){
		dim1=d1;
		dim2=d2;
	}
	void kalkulatuAzalera(){
		System.out.println("karratuaren Erronboaren= "+((dim1*dim2)/2));
	}
}
class ExeIrudia{
	public staic void main( String []args){
		Karratua k=new Karratua(2);
		LaukiZuzena lz= new LaukiZuzena(3,2);
		Erronboa e=new Erronboa(5,2);
		Hirukia h=new Hirukia(10,5);
		k.kalkulatuAzalera();
		lz.kalkulatuAzalera();
		e.kalkulatuAzalera();
		h.kalkulatuAzalera();
	}
}	