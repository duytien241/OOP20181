package createdata;

import java.io.IOException;
import java.util.ArrayList;

import datacount.GetID;
import enity.Location;
import enity.Organization;

public class CreateOrganiztion extends CreateEntity {
	private static int indeti ;
	private static ArrayList<String> orgName = new ArrayList<String>();
	private static ArrayList<String> orgdes = new ArrayList<String>();
	public CreateOrganiztion() throws IOException {

		indeti = Integer.parseInt(datacount.GetID.id.get(3));
		ReadFile rdf = new ReadFile();
		rdf.setlink("dataentity/organization.txt");
		orgName = rdf.readf();
		rdf.setlink("dataentity/organizationdes.txt");
		orgdes = rdf.readf();
	}
	public Organization getOrganization() throws IOException {
		String iden = "location" + ++indeti;
		String label = (String) orgName.get((int)(Math.random()*orgName.size()));
		String des = orgdes.get((int)(Math.random()*orgdes.size()));
		Organization tmp = new Organization(iden, label, des, this.getLink(),this.getDate()) ;
		return tmp;
	}
	public static long getIndeti() {
		return indeti;
	}
}
