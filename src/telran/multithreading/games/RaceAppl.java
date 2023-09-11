package telran.multithreading.games;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;

import telran.view.*;

public class RaceAppl {

	private static final int MAX_THREADS = 10;
	private static final int MIN_THREADS = 3;
	private static final int MIN_DISTANCE = 100;
	private static final int MAX_DISTANCE = 3500;
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEP = 5;
	public static void main(String[] args) {
		InputOutput io = new ConsoleInputOutput();
		Item[] items = getItems();
		Menu menu = new Menu("Race Game", items);
		menu.perform(io);

	}

	private static Item[] getItems() {
		Item[] res = {
				Item.of("Start new game", RaceAppl::startGame),
				Item.ofExit()
		};
		return res;
	}
	static void startGame(InputOutput io) {
		int nThreads = io.readInt("Enter number of the runners","Wrong number of the runners",
				MIN_THREADS, MAX_THREADS);
		int distance = io.readInt("Enter distance", "Wrong Distance",MIN_DISTANCE, MAX_DISTANCE);
		Race race = new Race(distance, MIN_SLEEP, MAX_SLEEP);
		Runner[] runners = new Runner[nThreads];
		Instant start = Instant.now();
		startRunners(runners, race, start);
		joinRunners(runners);
		displayWinner(race);
	}

	private static void displayWinner(Race race) {
		 
		 
		LinkedHashMap<Integer,Long> winners = race.getWinners();
		Set<Entry<Integer,Long>> entries = winners.entrySet();
		int place = 1;
		System.out.println("Place - Racer - Time");
		for(Entry<Integer, Long> entry : entries){
		    System.out.println("# "+ place + "     "+ entry.getKey() +  "       " +  entry.getValue() );
		    place++;
		}
//		System.out.println("Congratulations to runner " + race.getWinners());
		
	}

	private static void joinRunners(Runner[] runners) {
		IntStream.range(0, runners.length).forEach(i -> {
			try {
				runners[i].join();
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}
		});
		
	}

	private static void startRunners(Runner[] runners, Race race,Instant startTime) {
		IntStream.range(0, runners.length).forEach(i -> {
			runners[i] = new Runner(race, i +1,startTime);
			runners[i].start();
		});
		
	}

}