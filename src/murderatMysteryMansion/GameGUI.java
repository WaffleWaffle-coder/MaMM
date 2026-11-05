package murderatMysteryMansion;


import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class GameGUI extends JFrame {

    public static JTextArea outputArea;
    public static JTextField inputField;
    private JButton submitButton;
    private boolean b;
    private JScrollPane scrollPane;
    public static String[] actions;

    public GameGUI() {
    	b = true;
        setTitle("Murder at Mystery Mansion");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);
        
        inputField = new JTextField();
        submitButton = new JButton("Enter");

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(
            BorderFactory.createEmptyBorder(5, 10, 10, 10)
        );
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> sendCommand());
        inputField.addActionListener(e -> sendCommand());

        setVisible(true);
    }

    public void sendCommand() {
        String action = inputField.getText().trim().toLowerCase();
        
        if (b) {
        Game.print(Game.getCurrentRoom());
	    Game.print("What would you like to do? ");
	    b = false;
        }

        if (!action.isEmpty()) {
            outputArea.append("\n> " + action + "\n");

            //outputArea.append("\n> " + Game.getCurrentRoom().toString() + "\n");
			//Game.print("What would you like to do? ");
			action = action.replaceAll("\\b(the|to)\\b", "");
			action = action.replaceAll("\\s+", " ");
			//action.toLowerCase();
			//Game.print(action);
			 actions = action.split(" ");
			 
			//Game.print(actions[1]);
			switch(actions[0]) {
			case "save":
				Game.saveGame();
				Game.print("Saved Game.");
				break;
			case "load":
				Game.loadGame();
				Game.print("Game loaded");
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "east":
				Game.move(action);
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
			break;
			case "west":
				Game.move(action);
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "north":
				Game.move(action);
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "south":
				Game.move(action);
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "up":
				Game.move(action);
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "down":
				Game.move(action);
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "take" :
				/*
				if (actions.length == 1) {
					Game.print("Take what?");
				}
					
					else {
						 if (Game.getCurrentRoom().getItem(actions[1]) != null) {
							 if (!Game.getCurrentRoom().getItem(actions[1]).isHeavy()) {
							 Game.takeItem(Game.getCurrentRoom().getItem(actions[1]).getName());
							 Game.print("You take the " + Game.getCurrentRoom().getItem(actions[1]) + " and carry it with you!");
							 Game.getCurrentRoom().removeItem(actions[1]);
							 }
							 else
								 Game.print("You can't lift the " + Game.getCurrentRoom().getItem(actions[1])  + "!");
						 }
						 else
								Game.print("There is no " + actions[1] + " in this room.");
						 Game.getItems();
					}
					*/
				Game.takeItem(actions[1]);
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				
				break;
			case "i" :
				if (Game.getItems().size() == 0)
				{Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
					Game.print("You are carrying nothing.");
				}
				else {
					Game.print("You are carrying:");
					for (Item a : Game.getItems())
					{
						Game.print(a);
					}
				}
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "go" :
				Game.move(actions[1]);
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "exit":
				Game.print("Farewell.");
				break;
			case "use":
				Game.use();
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
				break;
			case "read":
				Game.read();
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
		        break;
			case "open":
				Game.open();
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
		        break;
			case "close":
				Game.close();
				Game.print(Game.getCurrentRoom());
		        Game.print("What would you like to do? ");
		        break;
			default:
				Game.print("Error: Enter a proper command");
				
			}
		}
            inputField.setText("");
        }
    
    public static void scrollToBottom() {
        SwingUtilities.invokeLater(() -> {
            outputArea.setCaretPosition(outputArea.getDocument().getLength());
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}