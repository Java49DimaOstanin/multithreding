package telran.multithreading.messaging;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageBoxCW {
	private BlockingQueue<String> queue = new LinkedBlockingQueue<>();
	public  void put(String message) throws InterruptedException {
		queue.put(message);
		
	}
	public  String get() throws InterruptedException {
		
		return queue.take();
	}
	public String take() {
		return queue.poll();
	}
}