package practicejava;

public class Bus extends Car{

	int p;
	
	public Bus(){		
	}
	
	public Bus(int p){
		this.p = p;
	}
	
	
	public Bus(int p,int v,String name){
		this(p);
		this.v = v;
	}
	
	void drive(){
		System.out.println("Bus速度： "+v);
	}
	
	void carry(){
		System.out.println(name+"Bus载人： "+this.p);
	}
	
	void sum(){
		System.out.println(name+"Bus速度： "+super.v);
		System.out.println(name+"Bus载人： "+p);
	}
}
