package examples.six_6;

import java.util.Arrays;

public class ThreadUsingExample {

	static final int SIZE = 50_000_000;
	static final int HALF = SIZE/2;
	static float[] arr = new float[SIZE]; 
	
	public static void main (String[] args) {
		
		calculateArrayWithoutThread();
		calculateArrayWithThreads();
		
	}
	
	
	public static void calculateArrayWithThreads() {
		double startTime = System.currentTimeMillis();
		float[] a1 = new float[HALF]; 
		float[] a2 = new float[HALF]; 
		float[] array = new float[SIZE] ;
		Arrays.fill(array, 1);
		//fillWithOne(array);

		System.arraycopy(arr, 0, a1, 0, HALF);
		System.arraycopy(arr, HALF, a2, 0, HALF);

		Thread th1 = new Thread( ()-> ThreadUsingExample.fillWithEq(a1, 0 ));
		Thread th2 = new Thread( ()-> ThreadUsingExample.fillWithEq(a1, 0 ));
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.arraycopy(a1, 0, arr, 0, HALF);
		System.arraycopy(a2, 0, arr, HALF, HALF);
		
		double endTime = System.currentTimeMillis();
		System.out.println("Time of operation with two threads = " + (endTime - startTime) );
	}
	
	
	
	public static void calculateArrayWithoutThread() {
		double startTime = System.currentTimeMillis();
		float[] array = new float[SIZE] ;
		//fillWithOne(array);
		Arrays.fill(array, 1);
		fillWithEq(array, 0);
		double endTime = System.currentTimeMillis();
		System.out.println("time of operation without thread = " + (endTime - startTime) );
	}
	
		
	private static void fillWithOne(float[] array) {
		for ( int i = 0; i < array.length; i++ ) {
			array[i] = 1;
		}
	}
	
	
	private static void fillWithEq(float[] array, int ref) {
		for ( int j = 0; j < array.length; j++ ) {
			int i = j + ref;
			array[i] = (float) ( array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2) )  ;
		}
	}
	
	
	


	
}
