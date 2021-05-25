import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class GameManager {

	private static Room bearLocation;
	private static Room pizzaLocation;
	
	public static void main(String[] args) {
		
	}
	
	public static void startGame(ArrayList<Room> rooms) {
		Scanner sc = new Scanner(System.in);
		int moves = 0;
		placer(rooms);
		while (!gameDone()) {
			System.out.println("You are in the " + bearLocation.getName() + ": " + bearLocation.getDesc() + ".");
			System.out.print("Enter N, S, E, or W to move: ");
			String direction = sc.next();
			mover(rooms, direction);
			moves += 1;
		}
		System.out.println("Eat up bear! You've found the pizza in " + bearLocation.getName() + ": " + bearLocation.getDesc() + ".");
		System.out.println("That took you " + moves + " moves.");
		System.out.println();
	}

	public static void placer(ArrayList<Room> rooms) {
		Random rand = new Random();
		int index = rand.nextInt(6);
		bearLocation = rooms.get(index);
		index = rand.nextInt(6);
		pizzaLocation = rooms.get(index);
		while (bearLocation == pizzaLocation) {
			index = rand.nextInt(6);
			pizzaLocation = rooms.get(index);
		}
	}
	
	public static void printMaze(ArrayList<Room> rooms) {
		for (Room room: rooms) {
			LinkedHashMap<String, String> borders = room.getBorders();
			System.out.println(room.getName() + ": " + room.getDesc());
			if (borders.get("N").equals(" ")) {
				System.out.println("No neighbors on the North");
			}
			else {
				System.out.println("Connected on the North to " + borders.get("N"));
			}
			if (borders.get("S").equals(" ")) {
				System.out.println("No neighbors on the South");
			}
			else {
				System.out.println("Connected on the South to " + borders.get("S"));
			}
			if (borders.get("E").equals(" ")) {
				System.out.println("No neighbors on the East");
			}
			else {
				System.out.println("Connected on the East to " + borders.get("E"));
			}
			if (borders.get("W").equals(" ")) {
				System.out.println("No neighbors on the West");
			}
			else {
				System.out.println("Connected on the West to " + borders.get("W"));
			}
			System.out.println();
		}
	}
	
	public static void mover(ArrayList<Room> rooms, String direction) {
		LinkedHashMap<String, String> borders = bearLocation.getBorders();
		if (borders.get(direction).equals(" ")) {
			System.out.println("You can't move in that direction.");
		}
		else {
			for (Room room:rooms) {
				if (room.getName().equals(borders.get(direction))) {
					bearLocation = room;
				}
			}
		}
	}
	
	public static boolean gameDone() {
		if (bearLocation == pizzaLocation) {
			return true;
		}
		else {
			return false;
		}
	}
}
