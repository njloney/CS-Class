import java.util.Scanner;
public class MovieDriver {
	public static void main(String[] args) {
		Movie movie = new Movie();
		boolean yesNo = true;
		Scanner Prompt = new Scanner(System.in);
		while (yesNo) {
			System.out.println("Enter the name of a movie");
			movie.setTitle(Prompt.nextLine());
			System.out.println("Enter the rating of the movie");
			movie.setRating(Prompt.nextLine());
			System.out.println("Enter the number of tickets sold for this movie");
			movie.setSoldTickets(Prompt.nextInt());
			System.out.println(movie.getTitle() + " (" + movie.getRating() +"): Tickets Sold: " + movie.getSoldTickets());
			System.out.println("Do you want to enter another? (y or n)");
			if (Prompt.nextLine().equals("y")) {
				yesNo = true;
				Prompt.nextLine();
			} else if(Prompt.nextLine().equals("n")) {
				System.out.println("Goodbye");
				yesNo = false;
				Prompt.nextLine();
			}
		
		}
	}
}
