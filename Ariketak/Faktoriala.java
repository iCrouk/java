
class Faktoriala{
	
	int kalkulatuFaktoriala( int zenbakia){
		if (zenbnakia==0) return 1;
		else return zenbakia* kalkulatufaktoriala(zenbakia-1);
		}
	}
	public static void main(String [ ] args){
		faktoriala berria= new faktoriala();
		System.out.println("2-ren faktoriala"+berria.kalakulatuFaktoriala(2));
		System.out.println("4-aren faktoriala"+ berria.kalkulatufaktoriala(4));
		System.out.println("6-ren faktoriala2+ berria.kalkulatuFaktoriala(6));
		System.out.println("10-aren faktoriala"+ berria.kalkulatuFaktoriala(10));
		}
}