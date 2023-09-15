package telran.multithreading;

public class FacekDeadLock {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("1");
		Thread.currentThread().join();
		System.out.println("2");
	}

}
