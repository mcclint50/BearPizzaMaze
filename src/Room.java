import java.util.LinkedHashMap;

public class Room {
	private String name;
	private String desc;
	private LinkedHashMap<String, String> borders;
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}

	public LinkedHashMap<String, String> getBorders() {
		return borders;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setBorders(LinkedHashMap<String, String> borders) {
		this.borders = borders;
	}
	
	public Room() {
		name = "";
		desc = "";
		borders = null;
	}
	
	Room(String name, String desc, LinkedHashMap<String, String> borders) {
		setName(name);
		setDesc(desc);
		setBorders(borders);
	}
}
