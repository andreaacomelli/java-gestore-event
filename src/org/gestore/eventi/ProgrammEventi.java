package org.gestore.eventi;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;

	public ProgrammEventi(String titolo) {
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
	
	public int nEventi() {
		return eventi.size();
	}
	
	public void removeEventi() {
		eventi.clear();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		eventi.sort(Comparator.comparing(Evento::getData));
		StringBuilder sb = new StringBuilder();
		sb.append(titolo).append("\n");

		for (Evento evento : eventi) {
		  sb.append(evento.getData().format(DateTimeFormatter.ISO_DATE)).append(" - ")
		     .append(evento.getTitolo()).append("\n");
		}

		return sb.toString();
	}
}
