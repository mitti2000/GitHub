
public class SantaClaus {
	private final int NumberOfReindeers = 2;
	public final int NumberOfLaps = 5;
	private int reindeersHungry = NumberOfReindeers;
	private boolean raceStarted = false;
	private boolean raceOver = false;
	private int notYetReadyForGoingHome = NumberOfReindeers;
	protected Reindeer theReindeers[];
	public SantaClaus() {
		theReindeers = new Reindeer[NumberOfReindeers];
		for (int i = 0; i < NumberOfReindeers; ++i) {
			theReindeers[i] = new Reindeer(this, "Reindeer Rudolf Rednose #"
					+ i); 
		}
	}
	public void preChristmasReindeerRace() {
		feedAllReindeers();
		waitForFeedingDone();
		startRacing();
		waitForFinishing();
		waitForGoingHome();
		letReindeerIntoStable();
	}
	protected void feedAllReindeers() {
		System.out.println("Starting Feeding...");
		for (int i = 0; i < NumberOfReindeers; ++i) {
			theReindeers[i].start();
		}
	}
	protected void waitForFeedingDone() {
		System.out.println("Reindeer Race starts soon...");
		synchronized (this) {
			try {
				while (reindeersHungry > 0) {
					wait();
				}
			} catch (InterruptedException e) {
			}
		}
	}
	protected synchronized void startRacing() {
		System.out.println("HO HO HO");
		raceStarted = true;
		notifyAll();
	}
	protected synchronized void waitForFinishing() {
		try {
			while (!raceOver) {
				wait();
			}
		} catch (InterruptedException e) {
		}
	}
	public synchronized void waitForGoingHome() {
		try {
			while (notYetReadyForGoingHome > 0)
				wait();
		} catch (InterruptedException e) {
		}
	}
	protected void letReindeerIntoStable() { // hier wartet Santa Claus bis alle Rentiere da
		 // und nicht eine Aktion wie im Text beschrieben
		for (int i = 0; i < NumberOfReindeers; ++i) {
			try {
				theReindeers[i].join();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("All reindeers are in the stable");
	}
	public synchronized void readyForStart() {
		reindeersHungry--;
		if (reindeersHungry <= 0)
			notifyAll();
	}
	public synchronized void waitForStart() {
		try {
			while (!raceStarted)
				wait();
		} catch (InterruptedException e) {
		}
	}
	public synchronized boolean raceIsOver() {
		return raceOver;
	}
	public synchronized void passFinishLine() {
		raceOver = true;
		notYetReadyForGoingHome--;
		notifyAll();
	}
	public int getNumberOfLaps() {
		return NumberOfLaps;
	}
}
