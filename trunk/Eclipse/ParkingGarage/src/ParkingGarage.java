public class ParkingGarage {
	private int places; // Anzahl freie Pl�tze
	
	public ParkingGarage ( int places)
	{
		if (places < 0)
		{
			throw new IllegalArgumentException("Parameter < 0");
		}
		
		this.places = places;
	}
	
	public synchronized void enter()
	{
		while (places == 0){
				try{
					wait();
				} catch(InterruptedException e){
					
				}
		}
	}
	
	

	public synchronized void leave()
	{
		places++;
	}
	

}
