package createdata;

import java.io.IOException;
import java.util.ArrayList;

import datacount.GetID;
import enity.Event;
import enity.Location;

public class CreateCountry extends CreateEntity {
	
	private static long indeti;
	private static ArrayList<String> countryName = new ArrayList<String>();
	private static ArrayList<String> countryDes = new ArrayList<String>();
	private ReadFile rdf;
	public CreateCountry() throws IOException {
		indeti = Integer.parseInt(datacount.GetID.id.get(0));
		rdf = new ReadFile();
		rdf.setlink("dataentity/country.txt");
		countryName = rdf.readf();
		rdf.setlink("dataentity/countrydes.txt");
		countryDes = rdf.readf();
	}
	public Event getCountry() throws IOException {
		String iden = "country" + ++indeti;
		String label = (String) countryName.get((int)(Math.random()*countryName.size()));
		String des = countryDes.get((int)(Math.random()*countryDes.size()));
		Event tmp = new Event(iden, label, des, this.getLink(),this.getDate()) ;
		return tmp;
	}
	public static long getIndeti() {
		return indeti;
	}
	public static void setIndeti(long indeti) {
		CreateCountry.indeti = indeti;
	}
	
}
