
	

	
	
	package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SpellCheckerController {


    private Dictionary dizionario=new Dictionary();
	ObservableList<String> languageBoxList = FXCollections.observableArrayList("English","Italian"); 
	private List<RichWord> parolecontrollate=new ArrayList<RichWord>();
	private List<RichWord> parolesbagliate=new ArrayList<RichWord>();
	
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
  @FXML
    private ChoiceBox<String> languageBox;
  
    /**
     * area di testo dove inserire il testo che verrà controllato
     */
    @FXML
    private TextArea txtTesto;
/**
* buttone che azione il controllo delle parole del txtTesto
*/
    @FXML
    private Button doSpellCheck;
/**
* area di testo dove appaiono le parole errate cioè quelle con corett=false
*/
    @FXML
    private TextArea txtWrongWords;
/**
* area di testo dove appare il numero di parole errate
*/
    @FXML
    private TextField txtCountErrors;

    @FXML
    private Button doClearText;
/**
* area di testo dove appare il tempo di processamento
*/
    @FXML
    private TextField txtTime;

    
    
    @FXML
    void doClearText(ActionEvent event) {
    	txtTesto.clear();
    	txtCountErrors.clear();
    	txtWrongWords.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	List<String> paroletesto=new ArrayList<String>();
    	String testo;
    	int i;
    	testo=txtTesto.getText();
    	
    	//tolgo la punteggiatura e caratteri speciali dal testo
    	testo.replaceAll( "[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]","");
//    	divido la stringa usando split intorno agli spazi per salvare le parole in una lista
    	
    		
    	String arraytesto[]=testo.split(" ");
    	for(i=0;i<arraytesto.length;i++) {
    		paroletesto.add(arraytesto[i]);
    		
    	}
    	String lingua=languageBox.getValue();
    	dizionario.loadDictionary(lingua);
//    	passo le parole nell'dizionario e ritornano con il valore corretto controllato dai dizionari
    	parolecontrollate=dizionario.spellCheckText(paroletesto);
//    	passo le parole per vedere quali sono veramente sbagliate e quelle no
    	parolesbagliate=dizionario.sbagliate(parolecontrollate);
//    	metto le parole nell'area di testo 
    	txtWrongWords.appendText(dizionario.ritornaparole(parolesbagliate));
    	txtTime.appendText(String.valueOf(System.nanoTime()).toString());
    	txtCountErrors.appendText(String.valueOf(parolesbagliate.size()));
    }
    
   
   
    
    @FXML
    void initialize() {
        assert languageBox != null : "fx:id=\"languageBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert doSpellCheck != null : "fx:id=\"doSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtWrongWords != null : "fx:id=\"txtWrongWords\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtCountErrors != null : "fx:id=\"txtCountErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert doClearText != null : "fx:id=\"doClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        languageBox.setItems(languageBoxList);
    }
}

	
	
	