package telran.multithreading;

import java.time.format.DateTimeFormatter;

public class TimerControllerAppl {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		
		timer.start();
		System.out.println("Doing somthing");
		Thread.sleep(5000);
		timer.interrupt();
		System.out.println("Doing somthing");
		Thread.sleep(5000);

	}

}
