package murderatMysteryMansion;


public class World {

	public static Room buildWorld() {
		Room foyer = new Room("Foyer", "This is the foyer of the mansion. It is quite small, and there is a seemingly dead body on the floor. Better find out whodunit.");
		Room library = new Room("Library", "This is the library. It is quite large, and seems to contain many boring books on various topics. There is a librarian sitting behind the counter.");
		Room bedroom = new Room("Bedroom",
				"This is the owner's bedroom. There is a dead laptop sitting on his desk as well as a safe hidden in the corner.");
		Room kitchen = new Room("Kitchen", "This is the kitchen. There is annoyed looking chef washing some dishes at the sink.");
		Room banquetRoom = new Room("Banquet Room", "This is the banquet room. It is very elegant looking with many flowers all over the place.");
		Room medicalRoom = new Room("Medical Room",
				"This is the medical room. There is a doctor currently sleeping at a desk.");
		Room diningHall = new Room("Dining Hall",
				"This is the dining hall. Nothing of real interest in here.");
		Room livingRoom = new Room("Living Room",
				"This is the living room. There are some cozy looking couches, and a charger laying on one of the seats.");
		Item charger = new Item("charger");
		Item laptop = new Item("laptop");
		Item key = new Item("key");
		Item flowers = new Item("flowers");
		Item body = new Item("body", true);
		Item knife = new Item("knife");
		Item book = new Item("book");
		foyer.addExit(library, 4);
		foyer.addExit(diningHall, 0);
		library.addExit(foyer, 5);
		library.addExit(banquetRoom, 0);
		bedroom.addExit(banquetRoom, 2);
		kitchen.addExit(diningHall, 2);
		banquetRoom.addExit(library, 1);
		banquetRoom.addExit(bedroom, 3);
		banquetRoom.addExit(medicalRoom, 0);
		medicalRoom.addExit(banquetRoom, 1);
		diningHall.addExit(livingRoom, 0);
		diningHall.addExit(kitchen, 3);
		diningHall.addExit(foyer, 1);
		livingRoom.addExit(diningHall, 1);
		livingRoom.addItem(charger);
		bedroom.addItem(laptop);
		library.addItem(key);
		banquetRoom.addItem(flowers);
		foyer.addItem(body);
		library.addItem(book);
		kitchen.addItem(knife);
		System.out.println(foyer);
		return foyer;
	}
	
	

	
}
