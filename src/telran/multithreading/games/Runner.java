package telran.multithreading.games;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Runner extends Thread {
private Race race;
private int runnerId;
private Instant startTime;
public Runner(Race race, int runnerId, Instant startTime) {
	this.race = race;
	this.runnerId = runnerId;
	this.startTime = startTime;
	
}
@Override
public void run() {
	int sleepRange = race.getMaxSleep() - race.getMinSleep() + 1;
	int minSleep = race.getMinSleep();
	int distance = race.getDistance();
//	Instant start = Instant.now();
	for (int i = 0; i < distance; i++) {
		try {
			sleep((long) (minSleep + Math.random() * sleepRange));
		} catch (InterruptedException e) {
			throw new IllegalStateException();
		}
		System.out.println(runnerId);
	}
	long raceTime = (long) ChronoUnit.MILLIS.between(startTime, Instant.now());
	race.setWinners( runnerId,raceTime);

}
}