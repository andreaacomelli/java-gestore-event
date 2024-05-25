package org.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Evento evento = new Evento("Evento di default", LocalDate.now().plusDays(1), 20, 0);
		
		evento.InserimentoDati();
		
		System.out.println("Cosa desideri fare: prenotare o disdire una prenotazione?");
		Scanner scan = new Scanner(System.in);
		String scelta = scan.nextLine().toLowerCase();
		
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
