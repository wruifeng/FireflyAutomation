package practicejava;

public class StaticClass {
	//静态变量
	public static int i = 0;
	
	public StaticClass(){
		i = 15;
	}
	
	public StaticClass(int n){
		i = n;
	}
	

	
	//静态方法
	public static void inc(String str){
		System.out.println(str);		
	}

	public static void inc(){
		i++;
	}
}
