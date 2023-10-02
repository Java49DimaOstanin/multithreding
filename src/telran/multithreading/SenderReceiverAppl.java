package telran.multithreading;

import java.util.ArrayList;
import java.util.List;

import telran.multithreading.consumer.Receiver;
import telran.multithreading.messaging.MessageBox;
import telran.multithreading.producer.Sender;

public class SenderReceiverAppl {

	private static final int N_MESSAGES = 100;
	private static final int N_RECEIVERS = 50;

	public static void main(String[] args) throws InterruptedException {
		MessageBox messageBox = new MessageBox();
		Sender sender = new Sender(messageBox, N_MESSAGES);
		sender.start();
		List<Receiver> receivers = startReceivers(messageBox);
		
		sender.join(); // wait for sender to finish
		
		for (Receiver receiver : receivers) {
//			receiver.join();
			receiver.stopRunning(); // stop all receivers
		}
		
//		Thread.sleep(200);
//		System.out.println("finish");
	}

	private static List<Receiver> startReceivers(MessageBox messageBox) {
		List<Receiver> receivers = new ArrayList<>();
		
		for (int i = 0; i < N_RECEIVERS; i++) {
			Receiver receiver = new Receiver(messageBox);
			receiver.start();
			receivers.add(receiver);
			
		}
		
		return receivers;
		
	}

}
