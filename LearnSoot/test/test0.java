import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import soot.toolkits.scalar.ArraySparseSet;
import soot.toolkits.scalar.FlowSet;


public class test0 {
	public static void main(String[] args) {
//		int i = Integer.parseInt(args[0]);
//		int j = i * i;
//		int k = j + j;
//		System.out.println(k);
		
//		FlowSet set = new ArraySparseSet();
//		FlowSet set1 = new ArraySparseSet();
//		set1.add(1);
//		FlowSet set2 = new ArraySparseSet();
//		set2.add(1);
//		set1.intersection(set2, set);
//		System.out.println(set);
//		
//		InfoItem item;
//		Set<InfoItem> set11 = new HashSet<InfoItem>();
//		item = new Local("1");
//		set11.add(item);
//		Set<InfoItem> set22 = new HashSet<InfoItem>();
//		item = new Local("1");
//		set22.add(item);
//		System.out.println(set11.equals(set22));
		
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		System.out.println(input);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		try {
			String strPhone = br.readLine();
			System.out.println(strPhone);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
