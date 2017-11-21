
public class Reindeer extends Thread {
	private SantaClaus theClaus;
	private int lapsToGo;
	public Reindeer(SantaClaus claus, String name){
		super(name);
		theClaus=claus;
		lapsToGo=theClaus.getNumberOfLaps();
	}
	public void run(){
		eatHay();
		waitAllReindeersReady();
		runRudolfRun();
		while (lapsToGo>0 && !theClaus.raceIsOver()){
			doLap();
		}
		passFinishLine();
		doLapOfHonor();
	}
	private void eatHay(){
		System.out.println(getName()+" Hmmm, Hmmm, Hmmm, the hay tastes fine");
		theClaus.readyForStart();
	}
	private void waitAllReindeersReady(){
		theClaus.waitForStart();
	}
	private void runRudolfRun() {
		System.out.println(getName()+" trappel trappel...Racing...");
	}
	private void doLap(){
		System.out.println(getName()+" laps to go"+lapsToGo);
		simulateRaceLap();
		--lapsToGo;
	}
	private void simulateRaceLap() {
		try {
			Thread.sleep((int)(1000*Math.random()));
		} catch (InterruptedException e) {
		}
	}
	private void passFinishLine() {
		System.out.println(getName()+" passed finish line, laps remaining "+lapsToGo);
		theClaus.passFinishLine();
	}
	private void doLapOfHonor() {
		theClaus.waitForGoingHome();
		System.out.println(getName()+" walks to the stable ...");
		simulateRaceLap();
	}

}
