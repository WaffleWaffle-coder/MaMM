package murderatMysteryMansion;

public class Laptop extends Item{
	private static boolean poweredOn;
	private boolean open;
	public Laptop() {
		super("laptop");
		poweredOn = false;
		open = false;
	}
	@Override
	public void use() {
		if (!open) {
		if (poweredOn) {
			Game.print("You turn on the computer, and it opens up to his emails.\n"
					+ "He has an unread email from bibliomancer@gmail.com"
					+ "\nIt says that if he does not pay them tomorrow, he's as good as dead."
					+ "/n...Maybe that's the killer? Hard to say for certain, though.");
			open = true;
		}
		else {
			Game.print("You try to turn on the computer, but it's dead. If only you had a way to charge it...");
		}
		}
		else {
			Game.print("The computer's closed...");
		}
	}
	@Override
	public void open() {
		this.use();
	}
	
	@Override 
	public void close() {
		if (open) {
			if (poweredOn) {
				Game.print("You turn off the computer.");
				open = false;
			}
			else {
				Game.print("The computer's dead...");
			}
			}
			else {
				Game.print("The computer's already closed...");
			}
	}
	
	public static void setPower(boolean b) {
		poweredOn = true;
	}
}
