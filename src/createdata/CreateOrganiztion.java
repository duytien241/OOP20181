package createdata;

import java.io.IOException;
import java.util.ArrayList;

import enity.Location;
import enity.Organization;

public class CreateOrganiztion extends CreateEntity {
	private static int indeti = 0 ;
	private static ArrayList<String> orgName = new ArrayList<String>();
	private static ArrayList<String> orgdes = new ArrayList<String>();
	public CreateOrganiztion() throws IOException {
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
}
