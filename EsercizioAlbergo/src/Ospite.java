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
		System.out.println(this.nome + " è ufficialmente entrato in albergo");
	}
	
	public void setPagato()
	{
		this.pagato = true;
		System.out.println(this.nome + " ha pagato ed è libero di andare");
	}
	
	public String infoOspite()
	{
		String stringa_checkIn;
		String stringa_pagato;
		

		if(checkIn)
			stringa_checkIn = " è già entrato ";
		else
			stringa_checkIn = " non è ancora entrato ";

		if(pagato)
			stringa_pagato = " ha pagato ";
		else
			stringa_pagato = " non ha pagato ";
		

		return this.nome + " nato il " + this.nascita.dataStringa() + stringa_checkIn + stringa_pagato;
	}
}
