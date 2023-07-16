package examples.threads_six_6;

public class ThreadRunnableExample {

	static class MyRunnableClass implements Runnable {

		@Override
		public void run() {
			for(int i = 0; i < 10; i++) {
				try {
					Thread.sleep(100);
					System.out.println("new thread "  + " "+ i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Thread(new MyRunnableClass()).start(); 
		new Thread(new MyRunnableClass()).start(); 

	}
}
