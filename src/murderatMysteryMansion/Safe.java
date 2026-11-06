package murderatMysteryMansion;

public class Safe extends Item{
	private boolean open;
	private boolean hasLaptop;
	public Safe() {
		super("safe", true);
		open = false;
		hasLaptop = false;
	}
	
	@Override
	public void open() {
		if (Game.getCurrentRoom().getName().equals("Bedroom")) {
			if (!open) {
				if (hasLaptop) {
					Game.print("Despire reopening the safe like it's a fridge, nothing new appears.");
				}
				else {
				Game.getCurrentRoom().addItem(new Laptop());
				Game.print("You open the safe and find the owner's laptop!");
				open = true;
				hasLaptop = true;
				}
			}
			else {
				Game.print("The safe is already open...");
			}
		}
		else
			Game.print("There isn't a safe in this room.");
	}
	
	@Override
	public void close() {
		if (Game.getCurrentRoom().getName().equals("Bedroom")) {
			if (open) {
				Game.print("You close the safe.");
				open = false;
			}
			else {
				Game.print("The safe is already closed...");
			}
		}
		else
			Game.print("There isn't a safe in this room.");
	}
	

}
