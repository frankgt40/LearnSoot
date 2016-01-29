import java.io.IOException;

public class IntraTest2 {
	private int field;
	public static void main(String[] args) throws IOException {
		int j, k = 0, l;
		int i = Integer.parseInt(args[0]);
		int two = 2;
		int[] array0 = new int[2];
		j = 10;
		while (j > 0 ){
			j = i - 1;
			if(i % 2 == 0){

				while(i < 0){
					i++;
				}
				array0[0] = 1;
				int z1 =0;
				if(z1 > 0){
					two++;
				}
				else{
					two--;
				}
				i=1;

				j = i + two;
				l = j;
			}
			else{
				k = two + two;
				l = k;
				if(l > 0){
					two++;
				}
				else{
					two--;
				}
			} 
		}

		two++;
		l = 2; 
		i = two;
		System.out.println(i);
		System.out.println(l);
		
		IntraTest2 t = new IntraTest2();
		t.field = l + i;
		
	
		int[] array = new int[2];
		array[0] = i;
		array[1] = 0;
		
		switch (i){
		case 0: break;
		case 1: i = i+1; break;
		case 3: j = i+1; break;
		case 2: k = i+1; break;
		}
		
		System.out.println(array);
	}
	
}
