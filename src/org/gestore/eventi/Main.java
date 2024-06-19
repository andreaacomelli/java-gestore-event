package org.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Evento evento = new Evento("Evento di default", LocalDate.now().plusDays(1), 20, 0);
		Concerto concerto = new Concerto("Concerto di default", LocalDate.now().plusDays(1), 20, 0, LocalTime.now().plusHours(1), 0);
		
		Concerto c1 = new Concerto("Annalisa", LocalDate.of(2025, 2, 22), 500, 40, LocalTime.of(22, 10), 60);
		Concerto c2 = new Concerto("bnkr44", LocalDate.of(2025, 1, 05), 1000, 300, LocalTime.of(21, 20), 60);
		Concerto c3 = new Concerto("Marco Mengoni", LocalDate.of(2025, 5, 10), 4000, 1000, LocalTime.of(21, 30), 60);
		
		ProgrammEventi programmEventi = new ProgrammEventi("Concerti");
		programmEventi.addEventi(c1);
		programmEventi.addEventi(c2);
		programmEventi.addEventi(c3);
		
		
		Scanner scan = new Scanner(System.in);
		String scelta;
		
		 do {	
			System.out.println("Che tipo di evento desideri gestire, generico o concerto?");
			scelta = scan.nextLine().toLowerCase();
			
			try {
				  if(scelta.equals("generico")) {
					  
				     evento.InserimentoDati();
				     
				     System.out.println("L'evento è stato registrato");
				     System.out.println(evento.toString());
				     
				  } 
				  else if (scelta.equals("concerto")) {
					  
				    concerto.InserimentoDati();
				    concerto.inserimentoDatiConcerto();
				    
				    System.out.println("L'evento è stato registrato");
				    System.out.println(concerto.toString());
				    
				  } else { throw new Exception("Opzione non valida"); }
				  
				} catch (Exception e) {
				  System.out.println("Errore: " + e.getMessage());
				}
			
		} while (!scelta.equals("generico") && !scelta.equals("concerto"));
		 
		 System.out.println("Evento registrato");
		 programmEventi.addEventi(evento);
		 System.out.println(programmEventi);
		 
		 
		 do {
			 System.out.println("Cosa desideri fare: prenotare o disdire una prenotazione?");
		 		scelta = scan.nextLine().toLowerCase();
		 		
		 		try {

			 		if (scelta.equals("prenotare")) {
			 			evento.prenota();
			 		}
			 		else if (scelta.equals("disdire")) {
			 			evento.disdici();
			 		} else { throw new Exception("Opzione non valida"); }
			 		
		 		}catch (Exception e) {
		 			System.out.println("Errore: " + e.getMessage());
				}
		 		
		} while (!scelta.equals("prenotare") && !scelta.equals("disdire"));
		 
				System.out.println("Evento aggiornato, il numero dei posti totali è: " + evento.getnPostiTotali() + ", mentre i posti prenotati sono: " + evento.getnPostiPrenotati());
				programmEventi.addEventi(evento);
				System.out.println(programmEventi.getEventi());
				
		scan.close();
	}
}
