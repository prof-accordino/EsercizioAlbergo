import java.util.Scanner;

/*
 * Questa classe l'ho creata per facilitare 
 * le operazioni di inserimento dei dati
 */
public class Inserisci
{
	static Scanner in = new Scanner(System.in);
	
	/*
	 * Questo metodo stampa un messaggio prima di prendere
	 * un intero dalla tastiera: rende l'inserimento più
	 * simile al python: se si vuole chiedere all'utente
	 * un numero intero bastera scrivere:
	 * 
	 *  int n = Inserisci.numero_intero("Metti un numero");
	 *  
	 *  Posso usare direttamente il nome della classe perché
	 *  si tratta di un metodo statico!
	 */
	public static int numero_intero(String messaggio)
	{
		System.out.println(messaggio);
		return Integer.parseInt(in.nextLine());
	}
	
	/*
	 * Uguale a numero_intero ma con il dobule
	 */
	public static double numero_virgola(String messaggio)
	{
		System.out.println(messaggio);
		return Double.parseDouble(in.nextLine());
	}
	/*
	 * Idem ma con le stringhe
	 */
	public static String stringa(String messaggio)
	{
		System.out.println(messaggio);		
		return in.nextLine();
	}
}
