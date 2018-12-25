package datacount;

import java.io.IOException;
import java.util.ArrayList;
import createdata.ReadFile;;

public class GetID {
	public static ArrayList<String> id;
	public GetID() throws IOException {
		ReadFile rd = new ReadFile();
		rd.setlink("idenfiti.txt");
		id = rd.readf();
	}
	
}
