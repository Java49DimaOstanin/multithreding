package telran.multithreading.games;

public class ThreadsDeadLock {

	public static void main(String[] args) {
		Object a = new Object();
		Race b = new Race(1, 2, 3);
		String c = "ABC"; 
		
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized(a) {
					System.out.println("A is synchronized from T1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(b) {
						System.out.println("B is synchronized from T1");
						
						
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				synchronized(b) {
					System.out.println("B is synchronized from T2");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(c) {
						System.out.println("C is synchronized from T2");
						
						
					}
				}
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				synchronized(c) {
					System.out.println("C is synchronized from T3");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(b) {
						System.out.println("B is synchronized from T3");
						
						
					}
				}
			}
		};
		
		
		t1.start();
		t2.start();
		t3.start();

	}

}
