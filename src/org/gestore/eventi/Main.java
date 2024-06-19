package org.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Evento evento = new Evento("Evento di default", LocalDate.now().plusDays(1), 20, 0);
		Concerto concerto = new Concerto("Concerto di default", LocalDate.now().plusDays(1), 20, 0, LocalTime.now().plusHours(1), 0);
		
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
			
		} while(!scelta.equals("generico") && !scelta.equals("concerto"));
		 
				System.out.println("Evento aggiornato, il numero dei posti totali è: " + evento.getnPostiTotali() + ", mentre i posti prenotati sono: " + evento.getnPostiPrenotati());
				
		scan.close();
	}
}
