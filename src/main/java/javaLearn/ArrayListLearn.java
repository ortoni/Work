package javaLearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListLearn {
	
	
	public static void main(String[] args) {
		String a ="abc(123)";
		String[] split = a.split("\\(");
		String[] k = split[1].split("\\)");
		System.out.println(k[0]);
	}

	/*public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("D");
		al.add("C");
		al.add("a");

		Collections.sort(al);	//	Orders in Ascending order
		//Collections.shuffle(al);	// Shuffle the values (Random order)
		Collections.reverse(al);	// place in Reverse order
		
		
		System.out.println(al);
		
		Iterator<String> iter = al.iterator();		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}*/

}
