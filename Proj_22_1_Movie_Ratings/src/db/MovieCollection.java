package db;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

import business.Movie;

public class MovieCollection {
	
	private List<Movie> movieList;
	
	public MovieCollection() {
		movieList = new ArrayList<>();
	}
	
	public List<Movie> getMovieList() {
     	return movieList;
    }

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public void add(Movie m) {
		movieList.add(m);
	}
	
	public List<Movie> filterMovies(Predicate<Movie> condition) {
		List<Movie> filteredMovies = new ArrayList<>();
	    for (Movie m: movieList) {
	      	if (condition.test(m)) {
	       		filteredMovies.add(m);
	       	}	    }
	    return filteredMovies;
	}
	
	public double getLowestRating() {
		double lowestRating = movieList.stream()
				.map(m -> m.getRating())
				.reduce(5.0, (a,b) -> Math.min(a, b));
		return lowestRating;
	} 
	
	public double getHighestRating() {
		double highestRating = movieList.stream()
				.map(m -> m.getRating())   // only get rating values
				.reduce(0.0, (a,b) -> Math.max(a, b));  
		// starting at 0.0, go through each element and take the max
		//    to find the highest rating
		return highestRating;
	}
	
	public double getAverageRating() {
		double sum = movieList.stream()
				.mapToDouble(m -> m.getRating())   // only get rating values
				.sum(); 
		
		return sum / movieList.size();
	}
	
	public int getSize() {
		return movieList.size();
	}

}
