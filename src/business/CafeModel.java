package business;

import main.Control;

public class CafeModel 
{

	private Control control;
	private String name;
	private String ort;
	private String beschreibung;
	private boolean ist_baeckerei_angeschlossen;
	private String[] cafe_produkte;

	

	public CafeModel(Control control, String name, String ort, String beschreibung, boolean ist_baeckerei_angeschlossen,
			String[] cafe_produkte)
	{
		this.control = control;
		this.name = name;
		this.ort = ort;
		this.beschreibung = beschreibung;
		this.ist_baeckerei_angeschlossen = ist_baeckerei_angeschlossen;
		this.cafe_produkte = cafe_produkte;
	}
	
	public String getCafeProdukteAlsStr(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getCafeProdukte().length - 1; i++) {
			ergebnis = ergebnis + this.getCafeProdukte()[i] + trenner; 
		}
		return ergebnis	+ this.getCafeProdukte()[i];
	}
	
	public String gibCafeZurueck(char trenner)
	{
		if(this.isIst_baeckerei_angeschlossen())
		{
			return this.getName() + trenner 
		  			+ this.getOrt() + trenner 
		  		    + this.getBeschreibung() + trenner 
		  		    + "Baeckerei ist angeschlossen" + trenner + "\n"
		  		    + this.getCafeProdukteAlsStr(trenner)+ "\n";
		}
		else
		{
			return this.getName() + trenner 
		  			+ this.getOrt() + trenner 
		  		    + this.getBeschreibung() + trenner 
		  		    + "Kein Baeckerei ist angeschlossen" + trenner + "\n" 
		  		    + this.getCafeProdukteAlsStr(trenner) + "\n";
		}

  	}


	public Control getControl()
	{
		return control;
	}

	public void setControl(Control control)
	{
		this.control = control;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOrt()
	{
		return ort;
	}

	public void setOrt(String ort)
	{
		this.ort = ort;
	}

	public String getBeschreibung()
	{
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung)
	{
		this.beschreibung = beschreibung;
	}

	public boolean isIst_baeckerei_angeschlossen()
	{
		return ist_baeckerei_angeschlossen;
	}

	public void setIst_baeckerei_angeschlossen(boolean ist_baeckerei_angeschlossen)
	{
		this.ist_baeckerei_angeschlossen = ist_baeckerei_angeschlossen;
	}

	public String[] getCafeProdukte()
	{
		return cafe_produkte;
	}

	public void setCafeProdukte(String[] caffees)
	{
		this.cafe_produkte = caffees;
	}
	
	
	
}

