package createdata;

import java.io.IOException;
import java.util.ArrayList;

import enity.Location;
import enity.Time;

public class CreateTime extends CreateEntity {
	private static int indeti = 0 ;
	private static ArrayList<String> timeName = new ArrayList<String>();
	private static ArrayList<String> timeDescription = new ArrayList<String>();
	public CreateTime() throws IOException {
		ReadFile rdf = new ReadFile();
		rdf.setlink("dataentity/time.txt");
		timeName = rdf.readf();
		rdf.setlink("dataentity/timedes.txt");
		timeDescription = rdf.readf();
	}
	public Time getTime() throws IOException {
		String iden = "location" + ++indeti;
		String label = (String) timeName.get((int)(Math.random()*timeName.size()));
		String des = timeDescription.get((int)(Math.random()*timeDescription.size()));
		Time tmp = new Time(iden, label, des, this.getLink(),this.getDate()) ;
		return tmp;
	}
}
