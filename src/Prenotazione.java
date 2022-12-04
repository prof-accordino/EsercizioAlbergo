public class Prenotazione
{
	Ospite[] arrayOspiti;
	int codice;
	int nCamera;
	double prezzo;
	Data checkIn;
	Data checkOut;
	static double prezzoGiorno = 25.0;

	public Prenotazione()
	{
		this.codice = Inserisci.numero_intero("Inserire codice prenotazione:");
		this.nCamera = Inserisci.numero_intero("Inserire numero camera:");

		boolean errore = true;
		while(errore)
		{	
			this.checkIn = new Data("Data check-in: ");
			this.checkOut = new Data("Data check-out: ");
			if(checkIn.maggioreDi(checkOut))
				System.out.println("Il check-in deve essere antecedente al checkOut");
			else
				errore = false;
		}
		
		this.prezzo = checkIn.distanzaGiorni(checkOut) * prezzoGiorno;
		
		// Inserisco gli ospiti
		int numeroOspiti = Inserisci.numero_intero("Quanti ospiti? (max 4)");
		while(numeroOspiti < 1 && numeroOspiti > 4)
			numeroOspiti = Inserisci.numero_intero("Ho detto max 4");
		
		arrayOspiti = new Ospite[numeroOspiti];
		for(int i = 0; i < numeroOspiti; i++)
			arrayOspiti[i] = new Ospite();
				
	}
	
	public void entraOspite(String nome)
	{
		for (int i = 0; i < arrayOspiti.length; i++)
			if(arrayOspiti[i] != null && arrayOspiti[i].nome.equals(nome))
			{
				arrayOspiti[i].setCheckIn();
				return;
			}
		System.out.print("Ospite non trovato");
	}
	
	public boolean haPagato(String nomeOspite)
	{
		int indicePieno = cercaInArray(nomeOspite);
		if(indicePieno == -1)
			System.out.print("Ospite non trovato");
		else
			return arrayOspiti[indicePieno].pagato;
		return false;
	}
	
	public void ospiteMaggiorenne(String nomeOspite)
	{
		int indicePieno = cercaInArray(nomeOspite);
		if(indicePieno == -1)
			System.out.print("Ospite non trovato");
		else
			if(arrayOspiti[indicePieno].maggiorenne())
				System.out.print("Ospite maggiorenne");
			else
				System.out.print("Ospite minorenne");
	}
	
	public double prezzoPrenotazione()
	{
		return prezzo;
	}
	
	public double prezzoOpsite()
	{
		return prezzo / arrayOspiti.length;
	}
	
	/*
	 * Questo metodo non era richiesto ma aiuta a visualizzare i dati
	 */
	public void stampaPrenotazione()
	{
		System.out.println("Prenotazione n. " + codice);
		System.out.println("Camera " + nCamera);
		System.out.println("Check-in " + checkIn.dataStringa());
		System.out.println("Check-out " + checkOut.dataStringa());
		
		for (int i = 0; i < arrayOspiti.length; i++)
			if(arrayOspiti[i] != null)
				System.out.println("Ospite " + (i+1) + " " + arrayOspiti[i].infoOspite());				
	}
	
	public int primoLibero()
	{
		for (int i = 0; i < arrayOspiti.length; i++)
			if(arrayOspiti[i] == null)
				return i;
		return -1;			
	}
	
	public int cercaInArray(String nome)
	{
		for (int i = 0; i < arrayOspiti.length; i++)
			if(arrayOspiti[i] != null && arrayOspiti[i].nome.equalsIgnoreCase(nome))
				return i;
		return -1;			
	}
}
