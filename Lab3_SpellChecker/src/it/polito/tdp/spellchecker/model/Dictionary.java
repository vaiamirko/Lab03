package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
public class Dictionary {
	// individuo la struttura dati più adatta a contenere le parole
	private Set<String> dizonarioinglese=new HashSet<String>();
	private Set<String> dizonarioitaliano=new HashSet<String>();
	private List<String> dizionarioSelezionato=new ArrayList<String>();
	private List<String> dizionarioInglese=new LinkedList<String>();
	private List<String> dizionarioItaliano=new LinkedList<String>();
//	private List<String> dizionarioInglese=new ArrayList<String>();
//	private List<String> dizionarioItaliano=new ArrayList<String>();
	
	/**
	 * metodo per definire i vari dionari di varie lingue in 
	 * una struttura dati appropriata
	 * @param language
	 */
	
	
	public void loadDictionary(String language) {
		
		if(language.equals("English")) {
			//se la lingua selezionata della choicebox è English
		try {
			FileReader fr = new FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
				dizionarioSelezionato.add(word);
				
				
			}
			br.close();
			 } catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		}
		
		else if(language.equals("Italian")) {
		try {
			//se la lingua selezionata è Italian
			FileReader fr = new FileReader("rsc/italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
				dizionarioSelezionato.add(word);
				
				
			}
			br.close();
			 } catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		}
		
		
		}
		public List<RichWord> spellCheckText(List<String> inputTextList){
			List<RichWord> WordChecked=new LinkedList<RichWord>();
			
//			if(dizionarioInglese.contains(inputTextList))
//				WordChecked.add(new RichWord(inputTextList, true))
			/**
			 * controllo che le parole siano corette cioè sono contenute in uno dei dizionari se è così posso 
			 * inserire nella lista la parola come corretta (corretta=true) altrimenti la inserirò come parola
			 * errata quindi corretta=false
			 */
			/*
			for(String s:inputTextList) {
				if(dizionarioInglese.contains(s)) {
					WordChecked.add(new RichWord(s, true));}
				else if(dizionarioItaliano.contains(s)) {
					WordChecked.add(new RichWord(s, true));}
				else {
//					se non è presente nei dizionari allora sarà una parola errata
					WordChecked.add(new RichWord(s, false));}
					
															
					
				}
				*/
			for(String s:inputTextList){
				if(dizionarioSelezionato.contains(s)) {
					WordChecked.add(new RichWord(s, true));}
				else
					WordChecked.add(new RichWord(s, false));
				
			}
					return WordChecked;
				
			}
		
		public List<RichWord> sbagliate(List<RichWord> listaparole){
			List<RichWord> wrong=new ArrayList<RichWord>();
			for(RichWord r:listaparole)
				if(r.isCorretta()==false)
					wrong.add(r);
					
			return wrong;
			
		}
			
	public String ritornaparole(List<RichWord >lista) {
		String parole = null;
		for(RichWord s:lista) {
			parole+=s.getParola()+"\n";
			
		}
			
		return parole;
		
	}
			
			
			
		
		
	}


