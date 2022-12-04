import java.util.Scanner;

public class Inserisci
{
	static Scanner in = new Scanner(System.in);
	
	public static int numero_intero(String messaggio)
	{
		System.out.println(messaggio);
		return Integer.parseInt(in.nextLine());
	}
	
	public static double numero_virgola(String messaggio)
	{
		System.out.println(messaggio);
		return Double.parseDouble(in.nextLine());
	}
	
	public static String stringa(String messaggio)
	{
		System.out.println(messaggio);		
		return in.nextLine();
	}
}
