package org.gestore.eventi;

import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int nPostiTotali;
	private int nPostiPrenotati = 0;

	public Evento(String titolo, LocalDate data, int nPostiTotali, int nPostiPrenotati) {
		this.setTitolo(titolo);
		this.setData(data);
		this.nPostiTotali = nPostiTotali = 20;
		this.nPostiPrenotati = nPostiPrenotati = 2;
		
		if (data.isBefore(LocalDate.now())) {
			System.out.println("Inserisci una data futura");
		}
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		data = LocalDate.of(2024, 5, 23);
		
	}

	public int getnPostiTotali() {
		return nPostiTotali;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}
	
	public void prenota() {
		if (data.isBefore(LocalDate.now()) || nPostiTotali == 20) {
			System.out.println("L'evento è già passato o non ha posti disponibili");
		} else {nPostiPrenotati =+1;}
	}
	
	public void disdici() {
		if (data.isBefore(LocalDate.now()) || nPostiPrenotati == 0) {
			System.out.println("L'evento è già passato o non ci sono prenotazioni");
		} else {nPostiPrenotati =-1;}
	}
	
	@Override
	public String toString() {
	    SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	    String stringaData = formatData.format(getData());
	    return stringaData + "-" + getTitolo()  ;
	}

}
