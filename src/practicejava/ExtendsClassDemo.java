package practicejava;
import practicejava.*;

public class ExtendsClassDemo {
	public static void main(String[] args){
	Bus bus = new Bus();
	Car car = bus;
	Bus bus2 = (Bus) car;
	System.out.println(bus2.p);
}
}