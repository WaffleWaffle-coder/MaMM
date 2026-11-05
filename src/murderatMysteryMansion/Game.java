package murderatMysteryMansion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Game {
	
	private static Room currentRoom;
	private static ArrayList<Item> items = new ArrayList<>();
	public static HashMap<String, String> des = new HashMap<>();
	
	public static void runGame() {
		printFile();
		Scanner input = new Scanner(System.in);
		String action = new String();
		while (!action.equals("exit")) {
			Game.print(currentRoom);
			Game.print("What would you like to do? ");
			action = input.nextLine().toLowerCase();
			action = action.replaceAll("\\b(the|to)\\b", "");
			action = action.replaceAll("\\s+", " ");
			Game.print(action);
			String[] actions = action.split(" ");
			//Game.print(actions[1]);
			Game.print(actions[0]);
			Game.print(action);
			switch(actions[0]) {
			case "east":
				move(action);
				System.out.println("string");
				break;
			case "west":
				move(action);
				break;
			case "north":
				move(action);
				break;
			case "south":
				move(action);
				break;
			case "up":
				move(action);
				break;
			case "down":
				move(action);
				break;
			case "take" :
				if (actions.length == 1) {
					Game.print("Take what?");
				}
					
					else {
						 if (currentRoom.getItem(actions[1]) != null) {
							 if (!currentRoom.getItem(actions[1]).isHeavy()) {
							 takeItem(currentRoom.getItem(actions[1]).getName());
							 Game.print("You take the " + currentRoom.getItem(actions[1]) + " and carry it with you!");
							 currentRoom.removeItem(actions[1]);
							 }
							 else
								 Game.print("You can't lift the " + currentRoom.getItem(actions[1])  + "!");
						 }
						 else
								Game.print("There is no " + actions[1] + " in this room.");
						
					}
				break;
			case "i" :
				if (items.size() == 0)
				{
					Game.print("You are carrying nothing.");
				}
				else {
					Game.print("You are carrying:");
					for (Item a : items)
					{
						Game.print(a);
					}
				}
				break;
			case "go" :
				move(actions[1]);
				break;
			case "exit":
				Game.print("Farewell.");
				break;
			default:
				Game.print("Error: Enter a proper command");
				
			}
		}
		input.close();
	}
	
	public static void takeItem(String t)
	{
		
		if (GameGUI.actions.length == 1) {
			Game.print("Take what?");
		}
			
			else {
				 if (getCurrentRoom().getItem(GameGUI.actions[1]) != null) {
					 if (!getCurrentRoom().getItem(GameGUI.actions[1]).isHeavy()) {
						 items.add(currentRoom.getItem(t));
					 print("You take the " + getCurrentRoom().getItem(GameGUI.actions[1]) + " and carry it with you!");
					 getCurrentRoom().removeItem(GameGUI.actions[1]);
					 }
					 else
						 print("You can't lift the " + getCurrentRoom().getItem(GameGUI.actions[1])  + "!");
				 }
				 else
						print("There is no " + GameGUI.actions[1] + " in this room.");
				 Game.getItems();
			}
		/*Game.print(Game.getCurrentRoom());
        Game.print("What would you like to do? ");
		if (currentRoom.getItem(t) != null)
		{
			
			items.add(currentRoom.getItem(t));
			
			
		}
		else
			Game.print("Error: There is no item in this room");*/
	}
	
	public static void print(Object obj)
	{
		GameGUI.outputArea.append("\n> " + obj + "\n");
		GameGUI.outputArea.getDocument().addDocumentListener(
			    new javax.swing.event.DocumentListener() {
			        private void updateScroll() {
			            SwingUtilities.invokeLater(() -> {
			                GameGUI.outputArea.setCaretPosition(
			                    GameGUI.outputArea.getDocument().getLength()
			                );
			            });
			        }

			        @Override
			        public void insertUpdate(
			                javax.swing.event.DocumentEvent e) {
			            updateScroll();
			        }

			        @Override
			        public void removeUpdate(
			                javax.swing.event.DocumentEvent e) {
			            updateScroll();
			        }

			        @Override
			        public void changedUpdate(
			                javax.swing.event.DocumentEvent e) {
			            updateScroll();
			        }
			    }
			);
		}
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void use() {
		
		boolean found = false;
		if (GameGUI.actions.length == 1) 
			Game.print("Use what?");
		else {
		if (getItems().size() == 0 && currentRoom.hasItems()) {
			Game.print("You don't have any items to use.");
		}
			else {

			for (int i = 0; i < getItems().size(); i++) {
				
				if (getItems().get(i).getName().equals(GameGUI.actions[1])) {
					getItems().get(i).use();
					found = true;
				}
			}
			if (!found) {
				if (currentRoom.getItem(GameGUI.actions[1])  == null)
					Game.print("There is no " + GameGUI.actions[1] + " to use!");
				else
					currentRoom.getItem(GameGUI.actions[1]).use();
			}
		}
		}
			
		}
		
	
	
	public static ArrayList<Item> getItems() {
		return items;
	}

	public static void move(String d) {
		
		if (d.equals("east"))
		{
			if (currentRoom.getExit(0) != null && !currentRoom.getExit(0).isLocked())
			{
				currentRoom = currentRoom.getExit(0);
			}
			else {
				Game.print("You can't go that way, sorry!");
			}
		}
		else if(d.equals("west"))
		{
			if (currentRoom.getExit(1) != null && !currentRoom.getExit(1).isLocked())
			{
				currentRoom = currentRoom.getExit(1);
			}
			else {
				Game.print("You can't go that way, sorry!");
			}
		}
		else if (d.equals("north")) {
			if (currentRoom.getExit(2) != null && !currentRoom.getExit(2).isLocked())
			{
				currentRoom = currentRoom.getExit(2);
			}
			else {
				Game.print("You can't go that way, sorry!");
			}
		}
		else if (d.equals("south")) {
			if (currentRoom.getExit(3) != null && !currentRoom.getExit(3).isLocked())
			{
				currentRoom = currentRoom.getExit(3);
			}
			else {
				Game.print("You can't go that way, sorry!");
			}
		}
		else if (d.equals("up")) {
			if (currentRoom.getExit(4) != null && !currentRoom.getExit(4).isLocked())
			{
				currentRoom = currentRoom.getExit(4);
			}
			else {
				Game.print("You can't go that way, sorry!");
			}
		}
		else if (d.equals("down")) {
			if (currentRoom.getExit(5) != null && !currentRoom.getExit(5).isLocked())
			{
				currentRoom = currentRoom.getExit(5);
			}
			else {
				Game.print("You can't go that way, sorry!");
			}
		}
		else
		{
			Game.print("Error: Please enter a valid direction.");
		}
	}
	public static void printFile() {
		try {
		Scanner fileScan = new Scanner(new File("something.txt"));
		String n = "";
		String d = "";
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			if (!line.equals("#")) {
				if (n.equals("")) 
					n = line;
				else {
					if (line.equals(""))
						d+= "\n\n";
					d += line;
				}
			}
			else {
				des.put(n, d);
				n = "";
				d = "";
			}
		}
		
		fileScan.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void saveGame() {
		try {
			File saveFile = new File("save.txt");
			saveFile.createNewFile(); 
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile));
		outStream.writeObject(currentRoom);
		outStream.writeObject(Room.returnRooms());
		outStream.writeObject(items);
		outStream.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void loadGame() {
		try {
		File saveFile = new File("save.txt");
		ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile));
		currentRoom = (Room) inStream.readObject();
		Room.setRooms(inStream.readObject());
		items = (ArrayList<Item>) inStream.readObject();
		inStream.close();
		}catch(Exception ex) {
		ex.printStackTrace();
	}
	}
	
	public static void runGameGUI() {
		printFile();
		GameGUI gui = new GameGUI();
		gui.sendCommand();
			
	}
	
	public static void addInventoryItem(Item i) {
		items.add(i);
	}
	
public static void read() {
		
	boolean found = false;
	if (GameGUI.actions.length == 1) 
		Game.print("Read what?");
	else {
	if (getItems().size() == 0 && currentRoom.hasItems()) {
		Game.print("You don't have any items to read.");
	}
		else {

		for (int i = 0; i < getItems().size(); i++) {
			
			if (getItems().get(i).getName().equals(GameGUI.actions[1])) {
				getItems().get(i).read();
				found = true;
			}
		}
		if (!found) {
			if (currentRoom.getItem(GameGUI.actions[1])  == null)
				Game.print("There is no " + GameGUI.actions[1] + " to read!");
			else
				currentRoom.getItem(GameGUI.actions[1]).read();
		}
	}
	}
		
	}
	
public static void open() {
	
	boolean found = false;
	if (GameGUI.actions.length == 1) 
		Game.print("Open what?");
	else {
	if (getItems().size() == 0 && currentRoom.hasItems()) {
		Game.print("You don't have any items to open.");
	}
		else {

		for (int i = 0; i < getItems().size(); i++) {
			
			if (getItems().get(i).getName().equals(GameGUI.actions[1])) {
				getItems().get(i).open();
				found = true;
			}
		}
		if (!found) {
			if (currentRoom.getItem(GameGUI.actions[1]) == null) {
			
				Game.print("There is no " + GameGUI.actions[1] + " to open!");
			}
			else {
				Game.print(GameGUI.actions[1]);
				Game.print(currentRoom);
				currentRoom.getItem(GameGUI.actions[1]).open();
			}
		}
	}
	}
		
	}
	

public static void close() {
	
	boolean found = false;
	if (GameGUI.actions.length == 1) 
		Game.print("Close what?");
	else {
	if (getItems().size() == 0 && currentRoom.hasItems()) {
		Game.print("You don't have any items to close.");
	}
		else {

		for (int i = 0; i < getItems().size(); i++) {
			
			if (getItems().get(i).getName().equals(GameGUI.actions[1])) {
				getItems().get(i).close();
				found = true;
			}
		}
		if (!found) {
			if (currentRoom.getItem(GameGUI.actions[1])  == null)
				Game.print("There is no " + GameGUI.actions[1] + " to close!");
			else
				currentRoom.getItem(GameGUI.actions[1]).close();
		}
	}
	}
		
	}
	
	public static void main(String[] args) {
		currentRoom = World.buildWorld();
		runGameGUI();
		
		
	}

}