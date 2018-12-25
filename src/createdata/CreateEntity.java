package createdata;

import java.io.IOException;
import java.util.ArrayList;

import datacount.GetID;

public class CreateEntity {
	private static ArrayList<String> link = new ArrayList<String>();
	private static ArrayList<String> date = new ArrayList<String>();
	private ReadFile rdf;
	public CreateEntity() throws IOException {
		datacount.GetID a = new GetID();
		rdf = new ReadFile();
		rdf.setlink("dataentity/link.txt");
		link = rdf.readf();
		rdf.setlink("dataentity/time.txt");
		date = rdf.readf();
	}
	public String getDate() {
		return date.get((int)(Math.random()*date.size()));
	}
	public String getLink() {
		return link.get((int)(Math.random()*link.size()));
	}
}
