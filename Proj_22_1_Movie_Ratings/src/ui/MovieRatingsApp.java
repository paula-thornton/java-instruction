package ui;

import java.time.LocalDate;

import java.util.List;

import business.Movie;
import db.MovieCollection;
import util.Console;

public class MovieRatingsApp {

	/*
	 * This app depends on the classes Movie and MovieCollection,
	 * which you have to write.  This main method gives you 
	 * some sample movies to use to add to your collection.
	 * Feel free to add some of your favorites to this list!
	 * Sean Blessing - May 2019
	 */
	public static void main(String[] args) {
		//initialize stuff
		MovieCollection mc = new MovieCollection();
		mc.add(new Movie("Avengers Infinity War", 2018, 4.0));
		mc.add(new Movie("Star Wars Episode 5 - Empire Strikes Back", 1980, 5.0));
		mc.add(new Movie("Sixteen Candles", 1984, 4.5));
		mc.add(new Movie("Happy Gilmore", 1996, 4.3));
		mc.add(new Movie("The Jerk", 1979, 3.9));
		mc.add(new Movie("Superbad", 2007, 3.9));
		mc.add(new Movie("Back to the Future Part III", 1990, 2.1));
		mc.add(new Movie("Entourage", 2015, 1.5));
		
		System.out.println("Welcome to the Movie Ratings application!\n");
		int choice = 0;
		
		while (choice!=6) {
			displayMenu();
		
			choice = Console.getInt("Choose a menu option:  ", 0, 7);
		
			List<Movie> filteredMovies;
			switch (choice) {
			
				case 1:		// Enter a movie
					int nbr = Console.getInt("How many movies do you want to enter?  ", 0, 11);
					for (int i = 1; i <= nbr; i++) {
						System.out.println("Movie # "+i);
						System.out.println("===========");
						String title = Console.getString("Enter title:  ");
						int year = Console.getInt("Enter year:  ");
						double rating = Console.getDouble("Enter rating:  ");
						Movie m = new Movie(title, year, rating);
						mc.add(m);
					}
					break;
					
				case 2:		// View top rated movies
					filteredMovies = mc.filterMovies(m -> m.getRating()>=4.0);
					System.out.println("Movies rated 4.0 or higher");
					System.out.println("==========================");
					printMoviesToConsole(filteredMovies);
					break;
					
				case 3:		// View most recent movies (movies released within last 10 years)
					int yearRange = LocalDate.now().getYear() - 10;
					filteredMovies = mc.filterMovies(m -> m.getYear()>=yearRange);
					System.out.println("Movies released in last 10 years");
					System.out.println("================================");
					printMoviesToConsole(filteredMovies);
					break;
					
				case 4:
					System.out.println("All movies");
					System.out.println("==========");
					
					// both of the next 2 statements do the same thing
					//	mc.getMovieList().stream().forEach(System.out::println);
					//	mc.getMovieList().stream().forEach(m -> System.out.println(m));
					//  replacing with below
					printMoviesToConsole(mc.getMovieList());
					break;
					
				case 5:		// View ratings
					System.out.println("Movie rating data");
					System.out.println("=================");
					System.out.println("Number of movies:  " + mc.getSize());
					System.out.println("Lowest rating:     " + mc.getLowestRating());
					System.out.println("Highest rating:    " + mc.getHighestRating());
					System.out.println("Average rating:    " + mc.getAverageRating());
					break;
					
				case 6:
					System.out.println("Goodbye!");
					break;
			}
		}
	}


	private static void printMoviesToConsole(List<Movie> movies) {
		movies.stream().forEach(System.out::println);
	}
	

	public static void displayMenu() {
		System.out.println("-----------------------");
		System.out.println("What do you want to do?");
		System.out.println("-----------------------");
		System.out.println("1 - Enter a movie");
		System.out.println("2 - View top rated movies");
		System.out.println("3 - View most recent movies");
		System.out.println("4 - View all movies");
		System.out.println("5 - View ratings");
		System.out.println("6 - Quit application");
        
        Console.println();
	}
	
}
