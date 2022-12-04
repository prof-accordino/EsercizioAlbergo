public class Ospite
{
	String nome;
	Data nascita;
	boolean checkIn = false;
	boolean pagato = false;
	
	public Ospite()
	{
		this.nome = Inserisci.stringa("Inserire nome ospite");
		this.nascita = new Data("Data di nascita");	
	}
	
	public boolean maggiorenne()
	{
		Data dataDiOggi = new Data("Data di oggi");
		int giorniDiVita = this.nascita.distanzaGiorni(dataDiOggi);
		return	 giorniDiVita > 18*365;
	}
	
	public void setCheckIn()
	{
		this.checkIn = true;
		System.out.println(this.nome + " � ufficialmente entrato in albergo");
	}
	
	public void setPagato()
	{
		this.pagato = true;
		System.out.println(this.nome + " ha pagato ed � libero di andare");
	}
	
	/*
	 * Questo metodo non era richiesto ma aiuta a stampare le informazioni sull'ospite
	 */
	public String infoOspite()
	{
		/*
		 * Questo � un trucco per fare gli if/else in un unica istruzione:
		 * condizione ? istruzione_true : istruzione_false;
		 */
		String info_checkin = checkIn ? " � gi� entrato " : " non � ancora entrato ";
		String info_pagato = pagato ? " ha gi� pagato" : " non ha ancora pagato ";

		return this.nome 
				+ " nato il " 
				+ this.nascita.dataStringa() 
				+ info_checkin + info_pagato;
	}
}
