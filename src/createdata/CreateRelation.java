package createdata;

import java.io.IOException;
import java.util.ArrayList;

public class CreateRelation {
	private static ArrayList<String> Relationdata = new ArrayList<String>();
	public CreateRelation(String file) throws IOException{
		ReadFile rdf = new ReadFile();
		rdf.setlink(file);
		Relationdata = rdf.readf();
	}
	public String getDate() {
		return Relationdata.get((int)(Math.random()*Relationdata.size()));
	}
}
