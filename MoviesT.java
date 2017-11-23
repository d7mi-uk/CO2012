package sample;
import java.io.*;
import java.util.Scanner;

public class MoviesT {

	
//	public static void computeRatings(){
//		File inFile = new File("ratings.csv");
//		try{
//		Scanner scan = new Scanner(inFile);
//		
//		scan.useDelimiter(",");
//		scan.nextLine(); //skip first line
//		double rats = 0;
//		int numberOfUsers = 0;
//		while(scan.hasNextLine() && rats <5){
//			System.out.println(scan.nextLine());
//			rats++;
//			
//		scan.nextLine();//
//		
//		}
//		scan.close();
//		}catch(FileNotFoundException e){
//			e.getMessage();
//		}
////		System.out.println(rats +"  "+ numberOfUsers);
//		
//	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movies test = new Movies();
		test.fillList();
		test.fillIdAndRating();
		
		
		//add a new Movie
		
//		test.addMovie("theTitle", "the Genres", 4.0);
		
//		test.sort();
		
		//delete movie with id number 7

//		test.deleteMovie(7);
//		test.deleteMovie(3);
		
//		Search for a movie with the namr fightclub
		
		System.out.println(test.search("fightclub").getTitle());
		
		System.out.println("\n\nList of All movies :  \n\n");
		for(Movies m : test.moviesList){
			System.out.println("ID : "+m.getId()+" TITLE : "+m.getTitle()+" GENRES : "+m.getGenres()+" ratings : "+m.getRating());
		}
		
		
		
		
		
		
		
		
	}

}
