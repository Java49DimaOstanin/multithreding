package telran.multithreading;

public class Truck extends Thread {
	
	private int load ;
	private static long elevator1;
	
	private static long elevator2;
	private int nloads;
	
	public Truck(int load, int nloads) {
		this.load = load;
		this.nloads = nloads;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < nloads; i++) {
			loadElevator1(load);
			loadElevator2(load);
		}
	}

	private static synchronized void loadElevator2(int load) {
		elevator2 += load;
		
	}

	private static synchronized void loadElevator1(int load) {
		elevator1 += load;
		
	}
	public static long getElevator1() {
		return elevator1;
	}

	public static long getElevator2() {
		return elevator2;
	}
}
