package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String Parola;
	private boolean Corretta;
	
	
	
	
	public RichWord(String parola, boolean corretta) {
		super();
		Parola = parola;
		Corretta = corretta;
	}
	public String getParola() {
		return Parola;
	}
	public void setParola(String parola) {
		Parola = parola;
	}
	public boolean isCorretta() {
		return Corretta;
	}
	public void setCorretta(boolean corretta) {
		Corretta = corretta;
	}
	
	

}
