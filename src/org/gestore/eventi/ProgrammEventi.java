package org.gestore.eventi;

import java.util.ArrayList;
import java.util.List;


/*
	Creare una classe ProgrammEventi con i seguenti attributi: 
	- titolo: String
	- eventi: List<Evento>
	Nel costruttore valorizzare il titolo, passato come parametro, e inizializzare la lista di eventi come una nuova ArrayList
	Aggiungere i seguenti metodi :
	un metodo che aggiunge alla lista un Evento, passato come parametro
	un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
	un metodo che restituisce quanti eventi sono presenti nel programma
	un metodo che svuota la lista di eventi
	un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data nella forma: 
	data1 - titolo1
	data2 - titolo2 
*/


public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;

	public ProgrammEventi(String titolo, List<Evento> eventi) {
		// TODO Auto-generated constructor stub
		this.titolo = titolo;
		this.eventi = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	public void addEventi(Evento evento) {
		eventi.add(evento);
	}
	
	public void printEventi() {
		System.out.println(eventi.toString());
	}
	
	public void nEventi() {
		System.out.println(eventi.size());
	}
	
	public void removeEventi() {
		eventi.clear();
	}
}
