package practicejava;

public class StaticClassDemo0 {
	static StaticClass v1;
	static StaticClass v2;
	static StaticClass v3;
	
	static{
		StaticClass.inc("This is a string#1");
		v3 = new StaticClass();
		v3.inc();
	}
	
	
	public static void main(String[] args){
		//≤‚ ‘æ≤Ã¨∑Ω∑®
		StaticClass.inc("This is a string#2");
		{
			
		}
		//≤‚ ‘æ≤Ã¨±‰¡ø
		
		v1 = new StaticClass();
		v2 = new StaticClass();
		System.out.println("v1.i="+v1.i+" v2.i="+v2.i);
		v1.inc();
		System.out.println("v1.i="+v1.i+" v2.i="+v2.i);	
		
	}
}
