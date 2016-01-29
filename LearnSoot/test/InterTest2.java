
public class InterTest2 {
	public void invoke1(int a, int b){
		int r = square(a);
		int s = add(r, b);
//		boolean flag = isPositive(s);
//		System.out.println(flag);
	}
	public int square(int c){
		return c * c;
	}
	public int add(int i, int j){
		int e = j + 2;
		return i + j;
	}
//	public boolean isPositive(int p){
//		
//		if(p > 0)
//			return true;
//		else
//			return false;
//	}
	
	public Assist invoke2(int d){
		Assist assist = new Assist(d);
		Assist a = assist;
		int f = a.getField();
		return a;
	}
	
	public static void main(String[] args) {
		InterTest2 demo = new InterTest2();
		demo.invoke1(Integer.parseInt(args[0]), -5);
		demo.invoke2(Integer.parseInt(args[1]));
	}

}
