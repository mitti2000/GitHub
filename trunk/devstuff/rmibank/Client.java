import java.rmi.Naming;

public class Client {

	public static void main(String[] args)
	{
		if (args.length < 2)
		{
			System.out.println("Benötigte Kommandozeilenargumente: <Name des Servers> <Name des Objektes>");
			return;
		}
		try
		{
			KontoManager server = (KontoManager) Naming.lookup("rmi://" + args[0] + "/" + args[1]);
			System.out.println("Kontakt zum Server hergestellt");
			Konto konto1 = server.eroeffnen("Fritz", 50000.0);
			System.out.println("Aktueller Kontostand: " + konto1.getKontostand());
			System.out.println("50 einzahlen:");
			konto1.einzahlen(50.0);
			System.out.println("Aktueller Kontostand: " + konto1.getKontostand());
			System.out.println("5000 einzahlen:");
			konto1.abheben(5000.0);
			System.out.println("Aktueller Kontostand: " + konto1.getKontostand());
			System.out.println("Name des Kontos");
			System.out.println(konto1.getName());


		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
