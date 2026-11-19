package murderatMysteryMansion;

public class Chef extends NPC {
	private int convoNum;
	public Chef() {
		super("chef"); 
		convoNum = 0;
	}

	@Override
	public void talk() {
		switch (convoNum) {
		case 0:
			convo0();
			break;
		case 1:
			convo1();
			break;
		case 2:
			convo2();
			break;
		case 3:
			convo3();
			break;
		case 4:
			convo4();
			break;
		case 5:
			convo5();
			break;
		case 6:
			convo6();
			break;
		case 7:
			convo7();
			break;
		}
	}
	
	public void convo0() {
		say("Ugh, what do you want?");
		String[] responses = { "Do you know why the owner's dead?", "Why are you so aggressive?", "Sorry, I'll leave you alone." };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("\"Don't know, don't care\"");
			convoNum = 1;
			break;
		case 2:
			say("\"Cause it's hot as hell in here, supposedly the owner wants to have a party later tonight, and there's an idiot blathering on in my ear.\"");
			convoNum = 2;
			break;
		case 3:
			say("\"Good. Go away.\"");
			convoNum = 3;
			break;
		default:
			say("\"If you don't have anything worthwhile to say, then go away.\"");
		}
	}
	
	
	
	public void convo1() {
		say("\"You know it's rude to keep bothering someone who's busy, right?\"");
		String[] responses = { "Come on, you have to know something.", "Sorry, I'll leave you alone." };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("\"There's a doctor here somewhere, I think. Now, PLEASE leave me alone.\"");
			convoNum = 4;
			break;
		case 2:
			say("\"Good. Go away.\"");
			convoNum = 3;
			break;
		default:
			say("\"If you don't have anything worthwhile to say, then go away.\"");
		}
	}
	
	public void convo2() {
		say("\"Stop talking to me. Go away.\"");
		String[] responses = { "What's the party for?", "Maybe you killed him.", "Tell me something worth my time, and I will." , "Why are you still preparing for a party if the owner's dead?"};
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("\"I don't know kid. He's some old rich person. They throw parties all the time.\"");
			convoNum = 5;
			break;
		case 2:
			say("\"What are you, a cop? Fuck off.\"");
			convoNum = 6;
			break;
		case 3:
			say("\"There's a doctor here somewhere. Now go away.\"");
			convoNum = 4;
			break;
		case 4:
			say("\"A family member will inherit everything, and I still need to be on their good side if I want to keep my job.\"");
			convoNum=5;
			break;
		default:
			say("\"If you don't have anything worthwhile to say, then go away.\"");
		}
	}
	
	public void convo3() {
		say("\"Fuck off.\"");
	}
	
	public void convo4() {
		say("\"I told you all I knew. Go away.\"");
		
	}
	
	public void convo5() {
		say("\"Will you ever leave me alone?\"");
		String[] responses = { "Sorry, I'll leave you alone.", "Tell me something worth my time, and I will." };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			Game.print("The chef doesn't say anything.");
			convoNum = 7;
			break;
		case 2:
			say("\"There's a doctor here somewhere. Now go away.\"");
			convoNum = 4;
			break;
		default:
			say("\"If you don't have anything worthwhile to say, then go away.\"");
		}
	}
	
	public void convo6() {
		say("\"If it'll get you off my back, there's a doctor here somewhere.\"");
	convoNum = 7;
	}
	
	public void convo7() {
		Game.print("Despite your best efforts, the chef ignores you.");
	}
	
	
}
