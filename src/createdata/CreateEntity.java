package createdata;

import java.io.IOException;
import java.util.ArrayList;

public class CreateEntity {
	private static ArrayList<String> link = new ArrayList<String>();
	private static ArrayList<String> date = new ArrayList<String>();
	public CreateEntity() throws IOException {
		ReadFile rdf = new ReadFile();
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
