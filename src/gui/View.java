package gui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Control;

public class View
{

	private Control control;
	private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    

	private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblOrt   		= new Label("Ort:");
    private Label lblBeschreibung  	 		= new Label("Beschreibung:");
    private Label lblIst_baeckerei_angeschlossen   			= new Label("Ist Baeckerei angeschlossen?");
    private Label lblCafeProdukte  		= new Label("Cafe Produkte::");
    private TextField txtName 	 			= new TextField();
    private TextField txtOrt		= new TextField();
    private TextField txtBeschreibung		= new TextField();
    private TextField txtIst_baeckerei_angeschlossen			= new TextField();
    private TextField txtCafeProdukte	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");
    private MenuItem mnItmTxtExport 		= new MenuItem("txt-Export");
    private Stage primaryStage;
    
    //IMPORT ERROR
	
	public View(Control control, Stage primaryStage)
	{
		this.control = control;
		this.primaryStage = primaryStage;
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Kaffee");
    	primaryStage.show();
    	this.initKomponenten();
    	this.initListener();
	}

	public Control getControl()
	{
		return control;
	}

	public void setControl(Control control)
	{
		this.control = control;
	}
	
	 public void initKomponenten(){
	       	// Labels
	    	lblEingabe.setLayoutX(20);
	    	lblEingabe.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	    	lblEingabe.setFont(font);
	    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeige.setLayoutX(400);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	       	lblName.setLayoutX(20);
	    	lblName.setLayoutY(90);
	    	lblOrt.setLayoutX(20);
	    	lblOrt.setLayoutY(130);
	    	lblBeschreibung.setLayoutX(20);
	    	lblBeschreibung.setLayoutY(170);
	    	lblIst_baeckerei_angeschlossen.setLayoutX(20);
	    	lblIst_baeckerei_angeschlossen.setLayoutY(210);
	    	lblCafeProdukte.setLayoutX(20);
	    	lblCafeProdukte.setLayoutY(250);    	
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	       		lblName, lblOrt, lblBeschreibung,
	       		lblIst_baeckerei_angeschlossen, lblCafeProdukte);
	    
	    	// Textfelder
	     	txtName.setLayoutX(170);
	    	txtName.setLayoutY(90);
	    	txtName.setPrefWidth(200);
	    	txtOrt.setLayoutX(170);
	    	txtOrt.setLayoutY(130);
	    	txtOrt.setPrefWidth(200);
	    	txtBeschreibung.setLayoutX(170);
	    	txtBeschreibung.setLayoutY(170);
	    	txtBeschreibung.setPrefWidth(200);
	      	txtIst_baeckerei_angeschlossen.setLayoutX(170);
	    	txtIst_baeckerei_angeschlossen.setLayoutY(210);
	    	txtIst_baeckerei_angeschlossen.setPrefWidth(200);
	    	txtCafeProdukte.setLayoutX(170);
	    	txtCafeProdukte.setLayoutY(250);
	    	txtCafeProdukte.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		txtName, txtOrt, txtBeschreibung,
	     		txtIst_baeckerei_angeschlossen, txtCafeProdukte);
	     	
	        // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvImport);
	  	    this.mnDatei.getItems().add(mnItmTxtImport);
	  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	  	    this.mnDatei.getItems().add(mnItmTxtExport);
	  	    
	 	    pane.getChildren().add(mnbrMenuLeiste);
	   }
		public void initListener()
		{
			System.out.println("wir sind in listener");
			btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) 
	            {
	        	    getControl().nehmeCafeAuf();
	            	
	            }
		    });
			
			getBtnAnzeige().setOnAction(new EventHandler<ActionEvent>()
			{
				
				@Override
				public void handle(ActionEvent arg0)
				{
					// TODO Auto-generated method stub
					getControl().zeigCafeAn();
				}
			});
			
			getMnItmCsvImport().setOnAction(new EventHandler<ActionEvent>()
			{
				
				@Override
				public void handle(ActionEvent arg0)
				{
					getControl().leseAusDatei("csv");
					
				}
			});
			
			getMnItmTxtImport().setOnAction(new EventHandler<ActionEvent>()
			{
				
				@Override
				public void handle(ActionEvent arg0)
				{
					getControl().leseAusDatei("txt");
					
				}
			});
			
			getMnItmCsvExport().setOnAction(new EventHandler<ActionEvent>()
			{
				
				@Override
				public void handle(ActionEvent arg0)
				{
					getControl().writeCafeInCsvDatei();
					
				}
			});
			
			getMnItmTxtExport().setOnAction(new EventHandler<ActionEvent>()
			{
				
				@Override
				public void handle(ActionEvent arg0)
				{
					getControl().writeCafeInTxtDatei();
					
				}
			});
			
			
		}


	public Stage getPrimaryStage()
	{
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}
	   
	public Label getLblEingabe()
	{
		return lblEingabe;
	}

	public void setLblEingabe(Label lblEingabe)
	{
		this.lblEingabe = lblEingabe;
	}

	public Label getLblAnzeige()
	{
		return lblAnzeige;
	}

	public void setLblAnzeige(Label lblAnzeige)
	{
		this.lblAnzeige = lblAnzeige;
	}

	public TextArea getTxtAnzeige()
	{
		return txtAnzeige;
	}

	public void setTxtAnzeige(TextArea txtAnzeige)
	{
		this.txtAnzeige = txtAnzeige;
	}

	public Button getBtnEingabe()
	{
		return btnEingabe;
	}

	public void setBtnEingabe(Button btnEingabe)
	{
		this.btnEingabe = btnEingabe;
	}

	public Button getBtnAnzeige()
	{
		return btnAnzeige;
	}

	public void setBtnAnzeige(Button btnAnzeige)
	{
		this.btnAnzeige = btnAnzeige;
	}

	public Menu getMnDatei()
	{
		return mnDatei;
	}

	public void setMnDatei(Menu mnDatei)
	{
		this.mnDatei = mnDatei;
	}

	public MenuItem getMnItmCsvImport()
	{
		return mnItmCsvImport;
	}

	public void setMnItmCsvImport(MenuItem mnItmCsvImport)
	{
		this.mnItmCsvImport = mnItmCsvImport;
	}

	public MenuItem getMnItmTxtImport()
	{
		return mnItmTxtImport;
	}

	public void setMnItmTxtImport(MenuItem mnItmTxtImport)
	{
		this.mnItmTxtImport = mnItmTxtImport;
	}

	public MenuItem getMnItmCsvExport()
	{
		return mnItmCsvExport;
	}

	public void setMnItmCsvExport(MenuItem mnItmCsvExport)
	{
		this.mnItmCsvExport = mnItmCsvExport;
	}

	public MenuItem getMnItmTxtExport()
	{
		return mnItmTxtExport;
	}

	public void setMnItmTxtExport(MenuItem mnItmTxtExport)
	{
		this.mnItmTxtExport = mnItmTxtExport;
	}

	public Pane getPane()
	{
		return pane;
	}

	public void setPane(Pane pane)
	{
		this.pane = pane;
	}

	public Label getLblName()
	{
		return lblName;
	}

	public void setLblName(Label lblName)
	{
		this.lblName = lblName;
	}

	public Label getLblOrt()
	{
		return lblOrt;
	}

	public void setLblOrt(Label lblOrt)
	{
		this.lblOrt = lblOrt;
	}

	public Label getLblBeschreibung()
	{
		return lblBeschreibung;
	}

	public void setLblBeschreibung(Label lblBeschreibung)
	{
		this.lblBeschreibung = lblBeschreibung;
	}

	public Label getLblIst_baeckerei_angeschlossen()
	{
		return lblIst_baeckerei_angeschlossen;
	}

	public void setLblIst_baeckerei_angeschlossen(Label lblIst_baeckerei_angeschlossen)
	{
		this.lblIst_baeckerei_angeschlossen = lblIst_baeckerei_angeschlossen;
	}

	public Label getLblCafeProdukte()
	{
		return lblCafeProdukte;
	}

	public void setLblCafeProdukte(Label lblCafeProdukte)
	{
		this.lblCafeProdukte = lblCafeProdukte;
	}

	public TextField getTxtName()
	{
		return txtName;
	}

	public void setTxtName(TextField txtName)
	{
		this.txtName = txtName;
	}

	public TextField getTxtOrt()
	{
		return txtOrt;
	}

	public void setTxtOrt(TextField txtOrt)
	{
		this.txtOrt = txtOrt;
	}

	public TextField getTxtBeschreibung()
	{
		return txtBeschreibung;
	}

	public void setTxtBeschreibung(TextField txtBeschreibung)
	{
		this.txtBeschreibung = txtBeschreibung;
	}

	public TextField getTxtIst_baeckerei_angeschlossen()
	{
		return txtIst_baeckerei_angeschlossen;
	}

	public void setTxtIst_baeckerei_angeschlossen(TextField txtIst_baeckerei_angeschlossen)
	{
		this.txtIst_baeckerei_angeschlossen = txtIst_baeckerei_angeschlossen;
	}

	public TextField getTxtCafeProdukte()
	{
		return txtCafeProdukte;
	}

	public void setTxtCafeProdukte(TextField txtCafeProdukte)
	{
		this.txtCafeProdukte = txtCafeProdukte;
	}

	public MenuBar getMnbrMenuLeiste()
	{
		return mnbrMenuLeiste;
	}

	public void setMnbrMenuLeiste(MenuBar mnbrMenuLeiste)
	{
		this.mnbrMenuLeiste = mnbrMenuLeiste;
	}   
	
		   
}


