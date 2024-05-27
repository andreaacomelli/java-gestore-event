package org.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Evento evento = new Evento("Evento di default", LocalDate.now().plusDays(1), 20, 0);
		Concerto concerto = new Concerto("Evento di default", LocalDate.now().plusDays(1), 20, 0, LocalTime.now().plusHours(1), 0);
		String scelta;
		
		
		System.out.println("Che tipo di evento desideri gestire, generico o concerto?");
		Scanner scan = new Scanner(System.in);
		scelta = scan.nextLine().toLowerCase();
		
		if (scelta.equals("generico")) {
			evento.InserimentoDati();
			System.out.println("L'evento è stato registrato");
		}
		else if (scelta.equals("concerto")) {
			concerto.InserimentoDati();
			concerto.inserimentoDatiConcerto(scan);
			System.out.println("L'evento è stato registrato");
		} else {
			System.out.println("Inserisci un'opzione valida");
		}
		
		System.out.println("Cosa desideri fare: prenotare o disdire una prenotazione?");
		scelta = scan.nextLine().toLowerCase();
		
		if (scelta.equals("prenotare")) {
			evento.prenota();
		}
		else if (scelta.equals("disdire")) {
			evento.disdici();
		} else {
			System.out.println("Inserisci un'opzione valida");
		}
		
		System.out.println("Evento aggiornato, il numero dei posti totali è: " + evento.getnPostiTotali() + ", mentre i posti prenotati sono: " + evento.getnPostiPrenotati());

		scan.close();
	}
}
