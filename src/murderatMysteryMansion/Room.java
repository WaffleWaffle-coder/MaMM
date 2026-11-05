package murderatMysteryMansion;





import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Room implements Serializable{

	private String name = "";
	private boolean locked;
	private Room[] arr;
	private HashMap<String, Item>  items;
	private static ArrayList<Room> rooms = new ArrayList<>();
	
	public Room(String n, String d)
	{
		name = n;
		arr = new Room[6];
		items = new HashMap<>();
		rooms.add(this);
		locked = false;
	}
	
	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return Game.des.get(name);
	}
	
	public void setRoom(String n)
	{
		name = n;
	}
	
	public void setDescription(String d)
	{
		Game.des.replace(Game.des.get(name), d);
	}
	
	public String toString()
	{
		String s = name;
		s += "\n\n" + Game.des.get(name);
		return s;
	}
	
	public void addExit(Room r, int i)
	{
		arr[i] = r;
	}
	
	public Room getExit(int i)
	{
		return arr[i];
	}
	
	public void addItem(Item i)
	{
		items.put(i.getName(), i);
	}
	
	public Item getItem(String n)
	{
		return items.get(n);
	}
	
	public void removeItem(String n) {
		items.remove(n);
	}
	
	public static ArrayList<Room> returnRooms() {
		return rooms;
	}
	
	public static void setRooms(Object object) {
		rooms = (ArrayList<Room>) object;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public boolean isLocked() {
		return locked;
	}

	public boolean hasItems() {
		return !items.isEmpty();
	}
	
}