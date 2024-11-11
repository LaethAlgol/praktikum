package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import business.CafeModel;
import gui.View;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class Control
{
	private CafeModel model;
	private View view;

	public Control(Stage primaryStage)
	{
		this.view = new View(this, primaryStage);

	}

	public void writeCafeInTxtDatei()
	{
		try
		{
			BufferedWriter aus = new BufferedWriter(new FileWriter("CafeTxTAusgabe.txt"));
			aus.write(this.getCafeModel().gibCafeZurueck(';'));
			aus.close();
			zeigeInformationsfensterAn("Das Cafe wurde als TxT gespeichert!");
		} catch (IOException exc)
		{
			zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc)
		{
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}

	}

	public void writeCafeInCsvDatei()
	{
		try
		{
			BufferedWriter aus = new BufferedWriter(new FileWriter("CafeCsvAusgabe.csv"));
			aus.write(this.getCafeModel().gibCafeZurueck(';'));
			aus.close();
			zeigeInformationsfensterAn("Das Cafe wurde als CVS gespeichert!");
		} catch (IOException exc)
		{
			zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc)
		{
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}

	}

	public void leseAusDatei(String typ)
	{
		try
		{
			if ("csv".equalsIgnoreCase(typ))
			{
				BufferedReader ein = new BufferedReader(new FileReader("CafeCsvAusgabe.csv"));
				
				String[] info_zeile = ein.readLine().split(";");
				String[] produkte_zeile = ein.readLine().split(";");

				if (info_zeile[3].equalsIgnoreCase("ja"))
				{
					this.setCafeModel(new CafeModel(this, info_zeile[0], info_zeile[1], info_zeile[2], true, produkte_zeile));
				} else
				{
					this.setCafeModel(new CafeModel(this, info_zeile[0], info_zeile[1], info_zeile[2], false, produkte_zeile));
				}

				ein.close();
				zeigeInformationsfensterAn("Das Cafe wurden gelesen!");
			} else if ("txt".equalsIgnoreCase(typ))
			{
				System.out.println("heloo");
				BufferedReader ein = new BufferedReader(new FileReader("CafeTxTAusgabe.txt"));

				String[] info_zeile = ein.readLine().split(";");
				String[] produkte_zeile = ein.readLine().split(";");

				if (info_zeile[3].equalsIgnoreCase("ja"))
				{
					this.setCafeModel(new CafeModel(this, info_zeile[0], info_zeile[1], info_zeile[2], true, produkte_zeile));
				} else
				{
					this.setCafeModel(new CafeModel(this, info_zeile[0], info_zeile[1], info_zeile[2], false, produkte_zeile));
				}
				
				ein.close();
				zeigeInformationsfensterAn("Das Cafe wurden gelesen!");
			}

			else
			{
				zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc)
		{
			zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
			exc.printStackTrace();
		} catch (Exception exc)
		{
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
			exc.printStackTrace();
		}

	}

	public void nehmeCafeAuf()
	{
		try
		{
			if (view.getTxtIst_baeckerei_angeschlossen().getText().equalsIgnoreCase("ja"))
			{
				this.model = new CafeModel(this, view.getTxtName().getText(), view.getTxtOrt().getText(),
						view.getTxtBeschreibung().getText(), true, view.getTxtCafeProdukte().getText().split(";"));
				zeigeInformationsfensterAn("Das Caffee wurde aufgenommen!");
			} else
			{
				this.model = new CafeModel(this, view.getTxtName().getText(), view.getTxtOrt().getText(),
						view.getTxtBeschreibung().getText(), false, view.getTxtCafeProdukte().getText().split(";"));
				zeigeInformationsfensterAn("Das Caffee wurde aufgenommen!");
			}
		}
		catch(Exception exc)
		{
			zeigeFehlermeldungsfensterAn(exc.getMessage());
			exc.printStackTrace();
		}
	}

	public CafeModel getCafeModel()
	{
		return model;
	}

	public void setCafeModel(CafeModel cafe)
	{
		this.model = cafe;
	}

	public View getView()
	{
		return view;
	}

	public void setView(View view)
	{
		this.view = view;
	}

	private void zeigeInformationsfensterAn(String meldung)
	{
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String meldung)
	{
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	public void zeigCafeAn()
	{
		if (this.model != null)
		{
			this.view.getTxtAnzeige().setText(this.model.gibCafeZurueck(' '));
			;
		} else
		{
			zeigeInformationsfensterAn("Bisher wurde kein Cafe aufgenommen!");
		}
	}

}
