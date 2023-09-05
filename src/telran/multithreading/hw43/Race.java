package telran.multithreading.hw43;


class Race {
    private final int distance;
    private volatile int winner = -1;
    private volatile boolean raceFinished = false;
    

    public Race(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getWinner() {
        return winner;
    }
    public synchronized boolean isRaceFinished() {
        return raceFinished;
    }

    public synchronized void finishRace() {
        raceFinished = true;
    }
}




