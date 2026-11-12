package murderatMysteryMansion;

public class Chef extends NPC {
	public Chef() {
		super("chef"); 
	}

	@Override
	public void talk() {
		say("Ugh, what do you want?");
		String[] responses = { "Do you know why the owner's dead?", "Why are you so aggressive?", "Sorry, I'll leave you alone." };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("\"Don't know, don't care\"");
			break;
		case 2:
			say("\"Cause it's hot as hell in here, supposedly the owner wants to have a party later tonight, and there's an idiot blathering on in my ear.\"");
			break;
		case 3:
			say("\"Good. Go away.\"");
			break;
		default:
			say("\"If you don't have anything worthwhile to say, then go away.\"");
		}
	}
}
