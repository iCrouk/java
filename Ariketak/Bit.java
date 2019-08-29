public class Bit{
	public static void main(string[] args){
		byte ready=1
		byte processing=2;
		byte recovering=4;
		byte error=8;
		byte momentuan="?";
	
	if((momentuan & ready)==ready)
		System.out.println("ready to receive requests");
	if((momentuan & proccesing)==processing)
		System.out.println("processing a requests");
	if((momentuan & recovering)==recovering)
		System.out.println("no recovery in progress");
	if((momentuan & error)== error)
		System.out.println("unrecoverable error occurred");}
}