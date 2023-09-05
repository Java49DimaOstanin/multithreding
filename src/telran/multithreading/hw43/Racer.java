package telran.multithreading.hw43;



class Racer extends Thread {
    private final Race race;
    private final int racerNumber;

    public Racer(Race race, int racerNumber) {
        this.race = race;
        this.racerNumber = racerNumber;
    }
    
    @Override
    public void run() {
        
        int distanceCovered = 0;
        int min = 2;
        int max = 5;
        while (distanceCovered < race.getDistance()) {
        	 if (race.isRaceFinished()) {
//        		 System.out.println("Race ended! for #" + racerNumber );
                 return;
             }
            try {
                
                int sleepTime = (int)Math.floor(Math.random() * (max - min + 1) + min);
                Thread.sleep(sleepTime);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            distanceCovered++;
           System.out.println("Racer #" + racerNumber + " at distance: " + distanceCovered);
        }

        if (race.getWinner() == -1) {
            race.setWinner(racerNumber);
            race.finishRace();
            System.out.println("Congratulations to thread #" + racerNumber + " W-I-N-N-E-R!");
        }
    }
}
