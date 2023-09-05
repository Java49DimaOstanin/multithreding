package telran.multithreading.hw43;
import telran.view.*;
import java.util.ArrayList;
import java.util.List;

public class RaceControllerApp {
    
	public static void main(String[] args) {
		
    	InputOutput io = new ConsoleInputOutput();
    	Menu menu = new Menu(" Threads Race ",
    			Item.of("Start game", io1-> crateParams(io1))	,
    			Item.ofExit());
    	menu.perform(io);
    	
    }

	public static void crateParams(InputOutput io) {
		
        int numThreads = io.readInt("Enter number of threds ", "Must be any number from 3 to 10",3,10);
		int distance = io.readInt("Enter running distance ", "Must be any number from 100-3500",100 , 3500);

	        Race race = new Race(distance);
	        List<Racer> racers = new ArrayList<>();

	        for (int i = 1; i <= numThreads; i++) {
	            Racer racer = new Racer(race, i);
	            racers.add(racer);
	            racer.start();
	        }
	        
	        for (Racer racer : racers) {
	            try {
	                racer.join();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        System.out.println("Race finished!");
	}
}
