public class Parking {
	
	public static void main(String[] args)
	{
		ParkingGarage garage = new ParkingGarage(10);
		
		
		for (int i = 1; i <= 40; i++)
		{
			new Car("Auto " + i, garage);
		}
	}

}