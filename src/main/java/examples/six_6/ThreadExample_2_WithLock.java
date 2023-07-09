package examples.six_6;

public class ThreadExample_2_WithLock {

	static int threadCounter = 1;
	private Object lock1 = new Object();
	
	public static void main(String[] args) {
		ThreadExample_2_WithLock e2 = new ThreadExample_2_WithLock();
		System.out.println("Start");
		new Thread( ()-> e2.method1()).start();
		new Thread( ()-> e2.method1()).start();
	}
	
	
	public synchronized void method1() {
		int counter = threadCounter;
		threadCounter++;
		System.out.println("Block-1 - begin");
		for(int i = 0; i < 3; i++) {
			System.out.println( "Thread № " + counter + " " + i );
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Block-1 - end" + counter);

		synchronized (lock1) {
			
			System.out.println("Sync block begin " + counter);
			for( int i = 0; i < 10; i++ ) {
				System.out.println("Thread № " + counter + " " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Sync block end" + counter);
			
		}
		System.out.println("End of method" + counter);
	
	}

}
