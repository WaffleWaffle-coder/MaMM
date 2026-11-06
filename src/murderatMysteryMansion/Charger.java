package murderatMysteryMansion;

public class Charger extends Item{
	private boolean used;
	public Charger() {
		super("charger");
	}
	
	@Override
	public void use() {
		boolean found = false;
		if (used) {
			Game.print("You don't have anything else to charge.");
		}
		else {
			for (int i = 0; i < Game.getItems().size(); i++) {
				if (Game.getItems().get(i).getName().equals("laptop")) {
					found = true;
				}
			}
			if (found) {
				Game.print("You used the charger to power up the laptop!");
				Laptop.setPower(true);
				used = true;
			}
			else {
				Game.print("You don't see anything to use the charger on...");
			}
		}
	}
}
