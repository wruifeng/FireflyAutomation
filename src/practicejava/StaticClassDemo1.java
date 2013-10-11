package practicejava;

public class StaticClassDemo1 {
	StaticClass v = new StaticClass(10);		
	static StaticClass v1,v2;
	
	static{
		System.out.println("初始化： v1.i="+v1.i+" v2.i="+v2.i);
		v1 = new StaticClass(27);
		System.out.println("初始化： v1.i="+v1.i+" v2.i="+v2.i);
		v2 = new StaticClass(15);
		System.out.println("初始化： v1.i="+v1.i+" v2.i="+v2.i);
	}
	
	
	public static void main(String[] args){

		StaticClassDemo1 test = new StaticClassDemo1();
		System.out.println("test.v.i="+test.v.i);
		v1 = new StaticClass();
		v2 = new StaticClass();
		System.out.println("v1.i="+v1.i+" v2.i="+v2.i);
		v1.inc();
		System.out.println("v1.i="+v1.i+" v2.i="+v2.i);	
		System.out.println("test.v.i="+test.v.i);
		
	}
}
