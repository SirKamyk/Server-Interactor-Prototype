import java.util.Scanner;

public class Controller {
	public static void main(String[]args) throws Exception {
		menu();
	}
	
	private static void menu() throws Exception {
		System.out.print("What would you like to do?\n1. Get a list of players\n2. Add a new player\n");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if(choice == 1) {
			generateGetRequest();
		}
		else if(choice == 2) {
			generatePostRequest();
		}
	}
	
	private static void generateGetRequest() throws Exception {
		GetRequest getReq1 = new GetRequest("https://quiet-dawn-25198.herokuapp.com/players");
		System.out.println(getReq1.send());
	}
	
	private static void generatePostRequest() throws Exception {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		PostRequest postReq1 = new PostRequest("https://quiet-dawn-25198.herokuapp.com/players",name);
		System.out.println(postReq1.send());
	}
}
