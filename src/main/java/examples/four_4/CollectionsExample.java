package examples.four_4;

import java.util.ArrayList;

public class CollectionsExample {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int[] arrNew = new int[10];
		
		System.arraycopy(arr, 0, arrNew, 0, arr.length);
		
		for (int i : arr) {
			System.out.print( i + " " );
		}
		System.out.println();		

		for (int i : arrNew) {
			System.out.print( i + " " );
		}
		System.out.println();
		
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		arrayList.add("D");
		arrayList.add("E");
		arrayList.add(1, "A0");
		System.out.println(arrayList);

		arrayList.remove("E");
		arrayList.remove(2);
		System.out.println(arrayList);
	
	}
}
