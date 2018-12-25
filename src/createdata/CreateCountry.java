package createdata;

import java.io.IOException;
import java.util.ArrayList;

import enity.Event;
import enity.Location;

public class CreateCountry extends CreateEntity {
	private static int indeti = 0 ;
	private static ArrayList<String> countryName = new ArrayList<String>();
	private static ArrayList<String> countryDes = new ArrayList<String>();
	public CreateCountry() throws IOException {
		ReadFile rdf = new ReadFile();
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
}
