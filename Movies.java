package sample;

import java.io.*;
import java.util.*;
public class Movies {

	int id;
	int movieId;
	String title;
	String genres;
	double rating;
	
	List <Movies> moviesList = new ArrayList <Movies>();
	
	public Movies (int mId, String mTitle, String mGenres){
		
//		id = iD;
		movieId = mId;
		title = mTitle;
		genres = mGenres;
	}
	
	public Movies(){
		
	}
	
	// ADDING THE 10 MOVIES TO THE LIST
	public void fillList(){
//	moviesList.add(new Movies(1, 86644, "Fast Five (2011)", "Action|Crime|Drama|Thriller|IMAX"));
//	moviesList.add(new Movies(2, 86911, "The Hangover Part II (2011)", "Comedy"));
//	moviesList.add(new Movies(3, 2959, "Fight Club (1999)", "Action|Crime|Drama|Thriller"));
//	moviesList.add(new Movies(4, 51935, "Shooter (2007)", "Action|Drama|Thriller"));
//	moviesList.add(new Movies(5, 52722, "Spider-Man 3 (2007)", "Action|Adventure|Sci-Fi|Thriller|IMAX"));
//	moviesList.add(new Movies(6, 54331, "You Kill Me (2007)", "Comedy|Crime|Thriller"));
//	moviesList.add(new Movies(7, 54513, "Talk to Me (2007)", "Drama"));
//	moviesList.add(new Movies(8, 59315, "Iron Man (2008)", "Action|Adventure|Sci-Fi"));
//	moviesList.add(new Movies(9, 63179, "Tokyo! (2008)", "Drama"));
//	moviesList.add(new Movies(10, 66596, "Mystery Team (2009)", "Comedy|Crime|Mystery"));
		moviesList.add(new Movies(86644, "Fast Five (2011)", "Action|Crime|Drama|Thriller|IMAX"));
		moviesList.add(new Movies(86911, "The Hangover Part II (2011)", "Comedy"));
		moviesList.add(new Movies(2959, "Fight Club (1999)", "Action|Crime|Drama|Thriller"));
		moviesList.add(new Movies(51935, "Shooter (2007)", "Action|Drama|Thriller"));
		moviesList.add(new Movies(52722, "Spider-Man 3 (2007)", "Action|Adventure|Sci-Fi|Thriller|IMAX"));
		moviesList.add(new Movies(54331, "You Kill Me (2007)", "Comedy|Crime|Thriller"));
		moviesList.add(new Movies(54513, "Talk to Me (2007)", "Drama"));
		moviesList.add(new Movies(59315, "Iron Man (2008)", "Action|Adventure|Sci-Fi"));
		moviesList.add(new Movies(63179, "Tokyo! (2008)", "Drama"));
		moviesList.add(new Movies(66596, "Mystery Team (2009)", "Comedy|Crime|Mystery"));
		
	}
	//fill the rating field and id for all the movies in the list
	public void fillIdAndRating(){
		int iid = 1;
		for(Movies m : moviesList){
			m.setId(iid);
			m.computeRatings();
			iid++;
		}
		
	}
	
	public void setMovieId(int mId){
		movieId = mId;
	}
	public void setRating(double r){
		rating = r;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setGenres(String genres){
		this.genres = genres;
	}
	
	
	public int getId(){
		return id;
	}
	public int getmovieId(){
		return movieId;
	}
	public String getTitle(){
		return title;
	}
	public String getGenres(){
		return genres;
	}
	public double getRating(){
		return rating;
	}
	
	
	// This method compute the aggregated rating for the movie only if it wasn't added by the user 
	public void computeRatings(){
		if(movieId != -1){
		File inFile = new File("resources/ratings.csv");
		try{
		Scanner scan = new Scanner(inFile);
		scan.useDelimiter(",");
		scan.nextLine(); //skip first line
		double rats = 0;
		int numberOfUsers = 0;
		while(scan.hasNextLine()){
			scan.nextInt(); // skip userId
			int movId = scan.nextInt();
			if(movId == movieId){
				rats += scan.nextDouble();
				numberOfUsers ++;
			}
		scan.nextLine();
		
		}
		scan.close();
		setRating(ratingFormat(rats/numberOfUsers));
		}catch(FileNotFoundException e){
			e.getMessage();
		}
		
		}
	}
	
	
	//delete a movie using movie id
	public void deleteMovie(int id){
		int counter = 0;
		for(Movies m : moviesList){
			if(m.getId() == id){
				moviesList.remove(counter);
				break;
//				m.setId(0);
			}
			counter++;
		}
		fillIdAndRating();
	}
	
	public void addMovie(String title2, String genres2, double rating2){
		Movies newMovie = new Movies(-1, title2, genres2);
//		newMovie.setMovieId(-1);
//		newMovie.setTitle(title2);
//		newMovie.setGenres(genres2);
		newMovie.setRating(rating2);
		moviesList.add(newMovie);
		fillIdAndRating();
		
	}
	
	
	//To be used in computeRatings()
	public static double ratingFormat(double d) {
	    return Math.round(d * 2) / 2.0;
	}
	
	
	
	
	public Movies search(String input){
		Movies ret = new Movies(0, "Movie not Found", "");
		
		for(Movies m : moviesList){
			String tit = m.getTitle().toLowerCase();
			if(tit.contains(input.toLowerCase())){
				ret = m;
			}
			
		}
		
		return ret;
	}
	public void sort(){
		
		moviesList.sort(Comparator.comparing(Movies::getRating));
		Collections.reverse(moviesList);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
