package telran.multithreading.games;

import java.util.LinkedHashMap;


public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	public LinkedHashMap<Integer,Long> winners;
	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		this.winners = new LinkedHashMap<>();
	}

	public  void setWinners(Integer time,long raceTime) {
		winners.put(time, raceTime);
	}
	public LinkedHashMap<Integer, Long> getWinners() {
		return winners;
	}
	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	
}