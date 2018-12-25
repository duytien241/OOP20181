package createdata;

import java.io.IOException;
import java.util.ArrayList;

import datacount.GetID;
import enity.Event;
import enity.Location;

public class CreateEvent extends CreateEntity {
	private static int indeti ;
	private static ArrayList<String> eventName = new ArrayList<String>();
	private static ArrayList<String> eventDescription = new ArrayList<String>();
	private ReadFile rdf;
	public CreateEvent() throws IOException {
		datacount.GetID a = new GetID();
		indeti = Integer.parseInt(datacount.GetID.id.get(1));
		rdf = new ReadFile();
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
	public static long getIndeti() {
		return indeti;
	}
	
}
