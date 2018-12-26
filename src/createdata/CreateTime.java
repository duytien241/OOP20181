package createdata;

import java.io.IOException;
import java.util.ArrayList;

import datacount.GetID;
import enity.Location;
import enity.Time;

public class CreateTime extends CreateEntity {
	private static int indeti ;
	private static ArrayList<String> timeName = new ArrayList<String>();
	private static ArrayList<String> timeDescription = new ArrayList<String>();
	private ReadFile rdf;
	public CreateTime() throws IOException {
		indeti = Integer.parseInt(datacount.GetID.id.get(5));
		rdf = new ReadFile();
		rdf.setlink("dataentity/time.txt");
		timeName = rdf.readf();
		rdf.setlink("dataentity/timedes.txt");
		timeDescription = rdf.readf();
	}
	public Time getTime() throws IOException {
		String iden = "time" + ++indeti;
		String label = (String) timeName.get((int)(Math.random()*timeName.size()));
		String des = timeDescription.get((int)(Math.random()*timeDescription.size()));
		Time tmp = new Time(iden, label, des, this.getLink(),this.getDate()) ;
		return tmp;
	}
	public static long getIndeti() {
		return indeti;
	}
}
