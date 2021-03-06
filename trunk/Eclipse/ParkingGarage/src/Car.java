public class Car extends Thread {
	private ParkingGarage garage;
	
	public Car(String name, ParkingGarage garage)
	{
		super(name);
		this.garage = garage;
		start();
	}
	
	public void run()
	{
		while (true)
		{
			try 
			{
				sleep((int) Math.random() * 10000);
			}
			catch (InterruptedException e)
			{
			}
			
			garage.enter();
			System.out.println(getName() + ": eingefahren");
			try 
			{
				sleep((int) Math.random() * 20000);
			}
			catch (InterruptedException e)
			{
			}
			
			garage.leave();
			System.out.println(getName() + ":ausgefahren");
		}
	}
	

}
