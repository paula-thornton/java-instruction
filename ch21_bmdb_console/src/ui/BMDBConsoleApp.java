package ui;

import java.time.LocalDate;
import java.util.List;

import business.Actor;
import business.Movie;
import db.MovieDB;
import db.ActorDB;
import util.Console;

public class BMDBConsoleApp {
	
	private static MovieDB movieDB = new MovieDB();
	private static ActorDB actorDB = new ActorDB();
	

	public static void main(String[] args) {
		System.out.println("bmdb Console App");
		
		int choice = 0;
		
		while (choice != 99) {
			choice = Console.getInt(getMenu(),0,100);

			switch (choice) {
			case 1:    // list movies
				List<Movie> movies = movieDB.list();
				System.out.println("List of movies: ");
				for (Movie m: movies) {
					System.out.println(m);
				}
				break;
			
			case 2:    // add movie
				System.out.println("Add a movie:");
				String t = Console.getString("Title:    ");
				String r = Console.getString("Rating:   ");
				int y = Console.getInt(      "Year:     ");
				String d = Console.getString("Director: ");	
				Movie m = new Movie(t, r, y, d);
				int rowCount = movieDB.add(m);
				if (rowCount == 1) {
					System.out.println("Movie added successfully");
				} else {
					System.out.println("Error adding movie... check logs");
				}
				break;
				
			case 3:    // update movie
				m = getMovie();
				if (m != null) {
					int year = Console.getInt("New year: ", 0, 2020);
					m.setYear(year);
					rowCount = movieDB.update(m);
					if (rowCount == 1) {
						System.out.println("Movie updated successfully");
					} else {
						System.out.println("Error updating movie");
					}
				} else {
					System.out.println("Error - movie ID doesn't exist.");
				}
				break;
				
			case 4:    // delete movie
				m = getMovie();
				if (m != null) {
					rowCount = movieDB.delete(m);
					if (rowCount == 1) {
						System.out.println("Movie deleted successfully");
					} else {
						System.out.println("Error deleting movie");
					}
				} else {
					System.out.println("Error - movie ID doesn't exist.");
				}
				break;
				
			case 5:    // get movie
				m = getMovie();
				if (m != null) {
					System.out.println(m);
				} else {
					System.out.println("Error - movie ID doesn't exist.");
				}
				break;
				
			case 6:    // list actors
				List<Actor> actors = actorDB.list();
				System.out.println("List of actors: ");
				for (Actor a: actors) {
					System.out.println(a);
				}
				break;
				
			case 7: 	// add actor            // PAGE 443
				String f = Console.getString("First Name: ");
				String l = Console.getString("Last Name:  ");
				String g = Console.getString("Gender:     ");
				String b = Console.getString("Birthdate:  ");
				LocalDate bd = LocalDate.parse(b);
				Actor a = new Actor(f, l, g, bd);
				rowCount = actorDB.add(a);
				if (rowCount == 1) {
					System.out.println("Actor added successfully");
				} else {
					System.out.println("Error adding actor... check logs");
				}
				
				break;
				
			case 8:		// update actor
				a = getActor();
				if (a != null) {
					b = Console.getString("New birthdate: ");
					bd = LocalDate.parse(b);
					a.setBirthDate(bd);
					rowCount = actorDB.update(a);
					if (rowCount == 1) {
						System.out.println("Actor updated successfully");
					} else {
						System.out.println("Error updating actor");
					}
				} else {
					System.out.println("Error - actor ID doesn't exist.");
				}
				break;
				
			case 9:		// delete actor
				a = getActor();
				if (a != null) {
					rowCount = actorDB.delete(a);
					if (rowCount == 1) {
						System.out.println("Actor deleted successfully");
					} else {
						System.out.println("Error deleting actor");
					}
				} else {
					System.out.println("Error - actor ID doesn't exist.");
				}
				break;
			
			case 10: 	// get actor
				a = getActor();
				if (a != null) {
					System.out.println(a);
				} else {
					System.out.println("Error - actor ID doesn't exist.");
				}
				break;
				
			case 99:    // exit
				break;
				
			default : 
				System.out.println("Invalid command.");
				break;
			}
		}

		System.out.println("Bye");
	}
	
	private static String getMenu() {
		String menu = "\nCOMMAND:\n" + 
						"1  = List Movies\t"  + "6  = List Actors\n" +
						"2  = Add Movie\t\t"  + "7  = Add Actor\n" +
						"3  = Update Movie\t" + "8  = Update Actor\n" +
						"4  = Delete Movie\t" + "9  = Delete Actor\n" +
						"5  = Get Movie\t\t"  + "10 = Get Actor\n" + 
						"99 = Exit\n" +
						"\nCommand: ";
		return menu;
	}
	
	private static Movie getMovie() {
		int id = Console.getInt("ID: ", 0, Integer.MAX_VALUE);
		Movie m = movieDB.get(id);
		return m;
	}
	
	private static Actor getActor() {
		int id = Console.getInt("ID: ", 0, Integer.MAX_VALUE);
		Actor a = actorDB.get(id);
		return a;
	}

}
