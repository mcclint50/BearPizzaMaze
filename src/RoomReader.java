import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class RoomReader {
	public static ArrayList<Room> readRooms(String fname) {
		try {
			Scanner fsc = new Scanner(new File(fname));
			String line;
			ArrayList<Room> rooms = new ArrayList<Room>();
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				rooms.add(roomParser(line));
			}
			fsc.close();
			return rooms;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static Room roomParser(String line) {
		String name;
		String desc;
		LinkedHashMap<String, String> borders = new LinkedHashMap<String, String>();
		String[] properties = line.split("\t");
		name = properties[0];
		desc = properties[1];
		borders.put("N", properties[2]);
		borders.put("S", properties[3]);
		borders.put("E", properties[4]);
		borders.put("W", properties[5]);
		return new Room(name, desc, borders);
		
	}
}
