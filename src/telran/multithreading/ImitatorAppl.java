package telran.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ImitatorAppl {

	private static final int N_REQUEST = 1000000;
	private static final long RUNNING_TIME = 100;

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Request> queue = new LinkedBlockingQueue<>();
		ClientImitator client = new ClientImitator(N_REQUEST,RUNNING_TIME,queue);
		ServerImitator server = new ServerImitator(queue);
		client.start();
		server.start();
		client.join();
		client.interrupt();
		server.interrupt();
		server.shutdown();
		System.out.printf("number of all requests :%d\n",N_REQUEST);
		System.out.printf("number of processed requests %d\n", Request.getActualRequestAmount());
		
	}

}
 