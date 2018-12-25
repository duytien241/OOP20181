package createdata;

import java.io.IOException;
import java.util.ArrayList;

import datacount.GetID;
import enity.Location;

public class CreateLocation extends CreateEntity {
	private static int indeti = 0 ;
	private static ArrayList<String> locationName = new ArrayList<String>();
	private static ArrayList<String> locationDescription = new ArrayList<String>();
	public CreateLocation() throws IOException {
		indeti = Integer.parseInt(datacount.GetID.id.get(2));
		ReadFile rdf = new ReadFile();
		rdf.setlink("dataentity/location.txt");
		locationName = rdf.readf();
		rdf.setlink("dataentity/locationdes.txt");
		locationDescription = rdf.readf();
	}
	public Location getLocation() throws IOException {
		String iden = "location" + ++indeti;
		String label = (String) locationName.get((int)(Math.random()*locationName.size()));
		String des = locationDescription.get((int)(Math.random()*locationDescription.size()));
		Location tmp = new Location(iden, label, des, this.getLink(),this.getDate()) ;
		return tmp;
	}
	public static long getIndeti() {
		return indeti;
	}
	
	
}
