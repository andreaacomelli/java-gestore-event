package org.gestore.eventi;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;


public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int nPostiTotali;
	private int nPostiPrenotati = 0;

	public Evento(String titolo, LocalDate data, int nPostiTotali, int nPostiPrenotati) {
		this.setTitolo(titolo);
		this.setData(data);
		this.nPostiTotali = nPostiTotali;
		this.nPostiPrenotati = nPostiPrenotati;
		
		if (data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Inserisci una data futura");
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
		if (data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Inserisci una data futura");
		}
		this.data = data;
	}

	public int getnPostiTotali() {
		return nPostiTotali;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}
	
	Scanner scan = new Scanner(System.in);
	
	public void prenota() {
		if (data.isBefore(LocalDate.now()) || nPostiPrenotati == nPostiTotali) {
			System.out.println("L'evento è già passato o non ha posti disponibili");
		} else {
			System.out.println("Quanti posti vuoi prenotare?");
			int nPostiDaPrenotare = scan.nextInt();
			nPostiPrenotati += nPostiDaPrenotare;
		}
	}
	
	public void disdici() {
		if (data.isBefore(LocalDate.now()) || nPostiPrenotati == 0) {
			System.out.println("L'evento è già passato o non ci sono prenotazioni");
		} else {
			System.out.println("Quanti prenotazioni vuoi disdire?");
			int nPostiDaDisdire = scan.nextInt();
			nPostiPrenotati -= nPostiDaDisdire;
		}
	}
	
	public void InserimentoDati() {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Inserisci il titolo dell'evento");
		titolo = scan.nextLine();
		
		System.out.println("Inserisci la data dell'evento(dd/MM/yyyy)");
		String inputData = scan.nextLine();
		
            data = LocalDate.parse(inputData, formatter);
     
		
		System.out.println("Inserisci i posti totali");
		nPostiTotali = scan.nextInt();
		
		System.out.println("Inserisci i posti prenotati");
		nPostiPrenotati = scan.nextInt();
	}
	
	@Override
	public String toString() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String stringaData = data.format(formatter);
	    return stringaData + " - " + getTitolo();
	}


}
