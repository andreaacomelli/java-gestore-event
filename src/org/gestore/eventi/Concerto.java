package org.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Concerto extends Evento {
	
	private LocalTime ora;
	private int prezzo;

	public Concerto(String titolo, LocalDate data, int nPostiTotali, int nPostiPrenotati, LocalTime ora, int prezzo) {
		super(titolo, data, nPostiTotali, nPostiPrenotati);
		// TODO Auto-generated constructor stub
		this.setOra(ora);
		this.setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	Scanner scan = new Scanner(System.in);
	
	public void inserimentoDatiConcerto() {
		DateTimeFormatter formattaOre = DateTimeFormatter.ofPattern("HH:mm");
		
		System.out.println("Inserisci l'orario del concerto (HH:mm):");
		String inputOrario = scan.nextLine();
		
            ora = LocalTime.parse(inputOrario, formattaOre);
		
		System.out.println("Inserisci il prezzo del biglietto:");
		prezzo = scan.nextInt();
		
		scan.nextLine();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DateTimeFormatter formattaOre = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter formattaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String stringaOrario = ora.format(formattaOre);
		
		return getData().format(formattaData) + "-" + stringaOrario + "-" + getTitolo() + "-" + getPrezzo() + "€";
	}
}
