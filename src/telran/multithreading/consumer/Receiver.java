package telran.multithreading.consumer;

import telran.multithreading.messaging.MessageBox;

public class Receiver extends Thread {
	private MessageBox messageBox;
	private boolean running = true;

	public Receiver(MessageBox messageBox) {
		this.messageBox = messageBox;
	}
	
	public void stopRunning() {
		this.running = false;
	}
	
	@Override
	public void run() {
		while(running) {
			try {
				String message = messageBox.get();
				if (message == null) {
					break;
				}
				System.out.printf("Thread %d has got message: %s \n",getId(), message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
