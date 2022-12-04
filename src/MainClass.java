public class MainClass
{
	static Prenotazione[] arrayPrenotazioni = new Prenotazione[1000];
	
	public static void main(String[] args)
	{
		while(true)
		{
			stampaMenu();
			int scelta = Inserisci.numero_intero("Inserisci la tua scelta:");
			switch (scelta)
			{
				case 0:		
					System.out.println("Goodbye!");
					return;
				case 1:
					inserisciPrenotazione();
					break;
				case 2:
					cambiaPrenotazione();
					break;
				case 3:
					rimuoviPrenotazione();
					break;
				case 4:
					impostaCheckInOspite();
					break;
				case 5:
					controllaPresenzaOspite();
					break;
				case 6:
					dateUguali();
					break;
				case 7:
					dateMaggori();
					break;
				case 8:
					ospiteMaggiorenne();
					break;
				case 9:
					prezzoPersona();
					break;
				case 10:	
					prezzoPrenotazione();
					break;
				case 11:	
					infoAlbergo();
					break;
					
				default:
					System.out.println("Solo numeri da 0 a 10 please!");
					break;
			}
		}
	}
	
	static void stampaMenu()
	{
		System.out.println("\nScegli un azione:");
		System.out.println("0 - Esci dal programma");
		System.out.println("1 - Inserire una nuova prenotazione");
		System.out.println("2 - Cambiare una nuova prenotazione");
		System.out.println("3 - Rimuovi una prenotazione");
		System.out.println("4 - Attiva entrata ospite");
		System.out.println("5 - Verifica presenza opsite");
		System.out.println("6 - Due date uguali");
		System.out.println("7 - Data maggiore di un'altra");
		System.out.println("8 - Ospite è maggiorenne?");
		System.out.println("9 - Prezzo totale di una persona");
		System.out.println("10 - Prezzo totale di una prenotazione");
	}
	
	static void inserisciPrenotazione()
	{
		int indiceLibero = primoLibero();
		if(indiceLibero == -1)
			System.out.println("Agenda piena");
		else
			arrayPrenotazioni[indiceLibero] = new Prenotazione();
	}
	
	static void cambiaPrenotazione()
	{
		int indicePieno = cercaInArray(Inserisci.numero_intero("Quale codice prenotazione?"));
		if(indicePieno == -1)
			System.out.println("Prenotazione non trovata!");
		else
			arrayPrenotazioni[indicePieno] = new Prenotazione();
	}
	
	static void rimuoviPrenotazione()
	{
		int codiceDaCercare = Inserisci.numero_intero("Quale codice prenotazione?");
		int indicePieno = cercaInArray(codiceDaCercare);
		if(indicePieno == -1)
			System.out.println("Prenotazione non trovata!");
		else
			arrayPrenotazioni[indicePieno] = null;
	}
	
	static void impostaCheckInOspite()
	{
		int codiceDaCercare = Inserisci.numero_intero("Quale codice prenotazione?");
		
		int indicePieno = cercaInArray(codiceDaCercare);
		if(indicePieno == -1)
			System.out.println("Prenotazione non trovata!");
		else
		{		
			String nomeOspite = Inserisci.stringa("Inserire nome ospite");
			arrayPrenotazioni[indicePieno].entraOspite(nomeOspite);
		}
	}
	
	static void controllaPresenzaOspite()
	{
		int codiceDaCercare = Inserisci.numero_intero("Quale codice prenotazione?");
		
		int indicePieno = cercaInArray(codiceDaCercare);
		if(indicePieno == -1)
			System.out.println("Prenotazione non trovata!");
		else
		{		
			String nomeOspite = Inserisci.stringa("Inserire nome ospite");
			arrayPrenotazioni[indicePieno].entraOspite(nomeOspite);
		}
	}
	static void dateUguali()
	{
		Data d1 = new Data("Inserire prima data");
		Data d2 = new Data("Inserire seconda data");
		if(d1.ugualeA(d2))
			System.out.println("Date uguali");
		else
			System.out.println("Date diverse");

	}
	static void dateMaggori()
	{
		Data d1 = new Data("Inserire prima data");
		Data d2 = new Data("Inserire seconda data");
		if(d1.maggioreDi(d2))
			System.out.println("La prima data è successiva alla seconda");
		else
			System.out.println("La seconda data è successiva alla prima");	
	}
	
	static void ospiteMaggiorenne()
	{
		int codiceDaCercare = Inserisci.numero_intero("Quale codice prenotazione?");
		
		int indicePieno = cercaInArray(codiceDaCercare);
		if(indicePieno == -1)
			System.out.println("Prenotazione non trovata!");
		else
		{		
			String nomeOspite = Inserisci.stringa("Inserire nome ospite");
			arrayPrenotazioni[indicePieno].ospiteMaggiorenne(nomeOspite);
		}
	}
	
	static void prezzoPersona()
	{
		int codiceDaCercare = Inserisci.numero_intero("Quale codice prenotazione?");		
		int indicePieno = cercaInArray(codiceDaCercare);
		if(indicePieno == -1)
			System.out.println("Prenotazione non trovata!");
		else
			arrayPrenotazioni[indicePieno].prezzoOpsite();	
	}
	
	static void prezzoPrenotazione()
	{
		int codiceDaCercare = Inserisci.numero_intero("Quale codice prenotazione?");		
		int indicePieno = cercaInArray(codiceDaCercare);
		if(indicePieno == -1)
			System.out.println("Prenotazione non trovata!");
		else
			arrayPrenotazioni[indicePieno].prezzoPrenotazione();	
	}
	
	static void infoAlbergo()
	{
		for (int i = 0; i < arrayPrenotazioni.length; i++)
			if(arrayPrenotazioni[i] != null)
				arrayPrenotazioni[i].stampaPrenotazione();
	}
	
	static int primoLibero()
	{
		for (int i = 0; i < arrayPrenotazioni.length; i++)
			if(arrayPrenotazioni[i] == null)
				return i;
		return -1;			
	}
	
	static int cercaInArray(int codice)
	{
		for (int i = 0; i < arrayPrenotazioni.length; i++)
			if(arrayPrenotazioni[i] != null && arrayPrenotazioni[i].codice == codice)
				return i;
		return -1;			
	}
}
