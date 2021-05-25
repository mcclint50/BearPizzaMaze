import java.util.ArrayList;
import java.util.Scanner;

public class McClinticPizzaHuntApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		printWelcome();
		System.out.print("Enter the name of file: ");
		String fname = sc.next();
		ArrayList<Room> rooms = RoomReader.readRooms(fname);
		while (choice != 3) {
			printMenu();
			System.out.print("Please enter the number of your choice: ");
			choice = sc.nextInt();
			if (choice == 1) {
				GameManager.startGame(rooms);
			}
			else if (choice == 2) {
				GameManager.printMaze(rooms);
			}
		}
		System.out.println("We hope you had fun and had enough pizza Please don't come near me though. I couldn't bear it!");
	}

	public static void printWelcome() {
		System.out.println("**************************************************");
		System.out.println("Pizza Hunt");
		System.out.println("You are a bear. Do what bears do. Hunt Pizza.");
		System.out.println("**************************************************");
		System.out.println();
	}
	
	public static void printMenu() {
		System.out.println("1. Hunt for Pizza");
		System.out.println("2. Print the maze");
		System.out.println("3. Hibernate");
	}
}
