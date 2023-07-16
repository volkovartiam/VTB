package examples.threads_six_6;

public class ThreadExample_1 {

	public static void main(String[] args) {
		ThreadExample_1 e1 = new ThreadExample_1();
		System.out.println("Start");
		new Thread( ()-> e1.method1()).start(); 
		new Thread( ()-> e1.method2()).start();
	}
	
	
	public synchronized void method1() {
		System.out.println("method1 start");
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
				System.out.println("new thread method1 "  + " "+ i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("method1 end");
	}

	
	public synchronized void method2() {
		System.out.println("method2 start");
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
				System.out.println("new thread method2 "  + " "+ i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("method2 end");
	}
	
}
