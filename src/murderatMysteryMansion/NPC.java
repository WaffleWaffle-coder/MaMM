package murderatMysteryMansion;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class NPC implements Serializable{
	private String name;
	public NPC(String n) {
		name = n;
	}
	
	public void say(String n) {
		Game.print(name.toUpperCase() +"\n" + n);
	}
	
	public void talk() {
		Game.print("You can't talk to " + name);
	}
	
	public int getResponse(String[] a) {
		for (int i = 0; i < a.length; i++) {
			Game.print((i+1) + ": \"" +a[i] + "\"");
		}
		String input = JOptionPane.showInputDialog(null, "Choose an option:");
		return Integer.parseInt(input);
	}
	
	public String getName() {
		return name;
	}
}
