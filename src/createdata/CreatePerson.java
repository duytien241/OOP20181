package createdata;

import java.io.IOException;
import java.util.ArrayList;

import enity.Location;
import enity.Person;

public class CreatePerson extends CreateEntity {
	private static int indeti = 0 ;
	private static ArrayList<String> personName = new ArrayList<String>();
	private static ArrayList<String> personDescription = new ArrayList<String>();
	private static ArrayList<String> personNational = new ArrayList<String>();
	private static ArrayList<String> personJob = new ArrayList<String>();
	public CreatePerson() throws IOException {
		ReadFile rdf = new ReadFile();
		rdf.setlink("dataentity/personname.txt");
		personName = rdf.readf();
		rdf.setlink("dataentity/persondes.txt");
		personDescription = rdf.readf();
		rdf.setlink("dataentity/country.txt");
		personNational = rdf.readf();
		rdf.setlink("dataentity/personJob.txt");
		personJob = rdf.readf();
		
	}
	public Person getPerson() throws IOException {
		CreateEntity cre = new CreateEntity();
		String iden = "person" + ++indeti;
		String label = (String) personName.get((int)(Math.random()*personName.size()));
		String des = personDescription.get((int)(Math.random()*personDescription.size()));
		String nation = personNational.get((int)(Math.random()*personNational.size()));;
		String job =personJob.get((int)(Math.random()*personJob.size()));
		int age = (int)(Math.random()*100);
		String male = (age%2==0)?"Nam":"Nữ";
		Person tmp = new Person(iden,label,des,nation,cre.getLink(),cre.getDate(),job,age,male);
		return tmp;
		
	}
	public static void main(String args[]) throws IOException {
		CreatePerson cr = new CreatePerson();
		Person tmp = cr.getPerson();
		Person tmp2 = cr.getPerson();
		CreateLocation crl = new CreateLocation();
		Location tmp3 = crl.getLocation();
		System.out.println(tmp.getLabel() + tmp.getLink());
		System.out.println(tmp3.getLabel() + tmp3.getLink());
	}
}
