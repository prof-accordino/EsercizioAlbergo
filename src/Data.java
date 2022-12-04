public class Data
{
	int giorno, mese, anno;
	
	public Data(String messaggio)
	{
		System.out.println(messaggio);		

		// Controllo approssimativo di validità giorno
		int prova_giorno = Inserisci.numero_intero("giorno: ");
		while(prova_giorno < 1 || prova_giorno > 31)
			prova_giorno = Inserisci.numero_intero("giorno non valido, reinserire");
		this.giorno = prova_giorno;
		
		// Controllo approssimativo di validità mese
		int prova_mese = Inserisci.numero_intero("mese: ");
		while(prova_mese < 1 || prova_mese > 12)
			prova_mese = Inserisci.numero_intero("mese non valido, reinserire");
		this.mese = prova_mese;
		
		this.anno = Inserisci.numero_intero("anno: ");	
	}
	
	public boolean ugualeA(Data data)
	{
		if(this.anno == data.anno && this.mese == data.mese  && this.giorno == data.giorno)
			return true;
		else
			return false;
	}
	
	public boolean maggioreDi(Data data)
	{
		if(this.anno > data.anno)
			return true;
		if(this.anno < data.anno)
			return false;
		// Qui si arriva solo se gli anni sono uguali
		
		if(this.mese > data.mese)
			return true;
		if(this.mese < data.mese)
			return false;	
		// Qui si arriva solo se i mesi sono uguali
		
		if(this.giorno > data.giorno)
			return true;
		if(this.giorno < data.giorno)
			return false;
		
		// Qui si arriva solo le date sono uguali
		return false; //uguale non è maggiore, quindi false!
	}
	
	/*
	 * Questo metodo non era necessario
	 * ma si rivela utile per calcolare
	 * il prezzo della prenotazione
	 * e capire se l'ospite è maggiorenne
	 */
	int distanzaGiorni(Data dataDiOggi)
	{
		int anni = dataDiOggi.anno - this.anno;
		int mesi = dataDiOggi.mese - this.mese;
		int giorni = dataDiOggi.giorno - this.giorno;
		
		//distanza giorni approssimativa
		return anni*365 + mese*30 + giorni;
	}
	
	/*
	 * Anche Questo metodo non era necessario ma è utile 
	 * per stampare le informazioni sulle date
	 */
	String dataStringa()
	{
		return this.giorno + "-" + this.mese+ "-" + this.anno;
	}
}
