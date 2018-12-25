package createdata;

import java.io.IOException;
import java.util.ArrayList;

import enity.Event;
import enity.Location;

public class CreateEvent extends CreateEntity {
	private static int indeti = 0 ;
	private static ArrayList<String> eventName = new ArrayList<String>();
	private static ArrayList<String> eventDescription = new ArrayList<String>();
	public CreateEvent() throws IOException {
		ReadFile rdf = new ReadFile();
		rdf.setlink("dataentity/event.txt");
		eventName = rdf.readf();
		rdf.setlink("dataentity/eventdes.txt");
		eventDescription = rdf.readf();
	}
	public Event getEvent() throws IOException {
		String iden = "event" + ++indeti;
		String label = (String) eventName.get((int)(Math.random()*eventName.size()));
		String des = eventDescription.get((int)(Math.random()*eventDescription.size()));
		Event tmp = new Event(iden, label, des, this.getLink(),this.getDate()) ;
		return tmp;
	}
}
