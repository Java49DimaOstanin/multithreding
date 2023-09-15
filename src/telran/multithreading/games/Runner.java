package telran.multithreading.games;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner extends Thread {
private Race race;
private AtomicInteger runnerId = new AtomicInteger();
public Runner(Race race, int runnerId) {
	this.race = race;
	this.runnerId.set(runnerId);
}
@Override
public void run() {
	int sleepRange = race.getMaxSleep() - race.getMinSleep() + 1;
	int minSleep = race.getMinSleep();
	int distance = race.getDistance();
	for (int i = 0; i < distance; i++) {
		try {
			sleep((long) (minSleep + Math.random() * sleepRange));
		} catch (InterruptedException e) {
			throw new IllegalStateException();
		}
		System.out.println("Runner # " + runnerId + "  distance= " + i );
	}
	race.setWinner(runnerId);
}
}