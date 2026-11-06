package murderatMysteryMansion;

public class Key extends Item{
	private boolean used;
	public Key() {
		super("key");
		used = false;
	}
	
	@Override
	public void use() {
		if (!used) {
		if (Game.getCurrentRoom().getName().equals("Banquet Room")) {
			Game.print("You used the key to unlock the medical room.");
			used = true;
			Game.getCurrentRoom().getExit(0).setLocked(false);
		}
		else {
			Game.print("You don't see any locked doors you could use this key on...");
		}
		}
		else {
			Game.print("You already unlocked the medical room!");
		}
	}
}
