package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;

import createdata.ReadFile;
import enity.*;
import createdata.*;
import virtuoso.rdf4j.driver.VirtuosoRepository;

public class InsertDB {
	private CreatePerson crp;
	private CreateLocation crl;
	private CreateEvent cre;
	private CreateOrganiztion cro;
	private CreateTime crt;
	private CreateCountry crc;
	private ArrayList<IRI> ListPerson;
	private ArrayList<IRI> ListLocation;
	private ArrayList<IRI> ListTime;
	private ArrayList<IRI> ListOrganization;
	private ArrayList<IRI> ListEvent;
	private ArrayList<IRI> ListCountry;
	
	private ArrayList<String> rePerson_Person;
	private ArrayList<String> rePerson_Organization;
	private ArrayList<String> rePerson_Location;
	private ArrayList<String> rePerson_Country;
	private ArrayList<String> rePerson_Event;
	
	private ArrayList<String> reOrganization_Person;
	private ArrayList<String> reOrganization_Organization;
	private ArrayList<String> reOrganization_Location;
	private ArrayList<String> reOrganization_Country;
	private ArrayList<String> reOrganization_Event;
	private ArrayList<String> reOrganization_Time;
	
	private ArrayList<String> reLocation_Person;
	private ArrayList<String> reLocation_Organization;
	private ArrayList<String> reLocation_Location;
	private ArrayList<String> reLocation_Country;
	private ArrayList<String> reLocation_Event;
	
	private ArrayList<String> reCountry_Person;
	private ArrayList<String> reCountry_Organization;
	private ArrayList<String> reCountry_Location;
	private ArrayList<String> reCountry_Country;
	private ArrayList<String> reCountry_Event;
	
	private ArrayList<String> reEvent_Person;
	private ArrayList<String> reEvent_Organization;
	private ArrayList<String> reEvent_Location;
	private ArrayList<String> reEvent_Country;
	private ArrayList<String> reEvent_Event;
	private ArrayList<String> reEvent_Time;
	private ReadFile rdf = new ReadFile();
	private InsertData inst ;
	private Random rnd;
	private IRI ent1 ;
	private IRI ent2;
	private IRI relas;
	public InsertDB() throws IOException{
		ListPerson = new ArrayList<IRI>();
		ListOrganization = new ArrayList<IRI>();
		ListLocation = new ArrayList<IRI>();
		ListTime = new ArrayList<IRI>();
		ListEvent = new ArrayList<IRI>();
		ListCountry = new ArrayList<IRI>();
		rnd = new Random();
		inst = new InsertData();
		rdf.setlink("rela/rePwP.txt");
		rePerson_Person = rdf.readf();
		rdf.setlink("rela/rePwO.txt");
		rePerson_Organization = rdf.readf();
		rdf.setlink("rela/rePwL.txt");
		rePerson_Location = rdf.readf();
		rdf.setlink("rela/rePwC.txt");
		rePerson_Country = rdf.readf();
		rdf.setlink("rela/rePwE.txt");
		rePerson_Event = rdf.readf();
		
		rdf.setlink("rela/reOwP.txt");
		reOrganization_Person = rdf.readf();
		rdf.setlink("rela/reOwO.txt");
		reOrganization_Organization = rdf.readf();
		rdf.setlink("rela/reOwL.txt");
		reOrganization_Location = rdf.readf();
		rdf.setlink("rela/reOwC.txt");
		reOrganization_Country = rdf.readf();
		rdf.setlink("rela/reOwE.txt");
		reOrganization_Event = rdf.readf();
		rdf.setlink("rela/reOwT.txt");
		reOrganization_Time = rdf.readf();
		
		rdf.setlink("rela/reLwP.txt");
		reLocation_Person = rdf.readf();
		rdf.setlink("rela/reLwO.txt");
		reLocation_Organization = rdf.readf();
		rdf.setlink("rela/reLwL.txt");
		reLocation_Location = rdf.readf();
		rdf.setlink("rela/reLwC.txt");
		reLocation_Country = rdf.readf();
		rdf.setlink("rela/reLwE.txt");
		reLocation_Event = rdf.readf();
		
		rdf.setlink("rela/reCwP.txt");
		reCountry_Person = rdf.readf();
		rdf.setlink("rela/reCwO.txt");
		reCountry_Organization = rdf.readf();
		rdf.setlink("rela/reCwL.txt");
		reCountry_Location = rdf.readf();
		rdf.setlink("rela/reCwC.txt");
		reCountry_Country = rdf.readf();
		rdf.setlink("rela/reCwE.txt");
		reCountry_Event = rdf.readf();
		
		rdf.setlink("rela/reEwP.txt");
		reEvent_Person = rdf.readf();
		rdf.setlink("rela/reEwO.txt");
		reEvent_Organization = rdf.readf();
		rdf.setlink("rela/reEwL.txt");
		reEvent_Location = rdf.readf();
		rdf.setlink("rela/reEwC.txt");
		reEvent_Country = rdf.readf();
		rdf.setlink("rela/reEwE.txt");
		reEvent_Event = rdf.readf();
		rdf.setlink("rela/reEwT.txt");
		reEvent_Time = rdf.readf();
		crp = new CreatePerson();
		crt = new CreateTime();
		cre = new CreateEvent();
		crl = new CreateLocation();
		cro = new CreateOrganiztion();
		crc = new CreateCountry();
	}
	public void GenEntity(int numberentity) throws IOException {
		for(int i = 0 ;i < numberentity ; i++) {
			int t = rnd.nextInt(6);
			switch (t) {
			case 0:
				ListPerson.add(inst.addEntity(crp.getPerson()));
				break;
			case 1:
				ListOrganization.add(inst.addEntity(cro.getOrganization()));
				break;
			case 2:
				ListEvent.add(inst.addEntity(cre.getEvent()));
				break;
			case 3:
				ListLocation.add(inst.addEntity(crl.getLocation()));
				break;
			case 4:
				ListTime.add(inst.addEntity(crt.getTime()));
				break;
			case 5:
				ListCountry.add(inst.addEntity(crc.getCountry()));
				break;
			default:
				break;
			}
		}
		
	}
	public void GenRela(int numberrela) {
		for(int i = 0; i < numberrela; i++) {
			
			int t = rnd.nextInt(26);
			switch (t) {
			case 0:
				ent1 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				ent2 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				relas = inst.addRela(rePerson_Person.get((int)(Math.random()*rePerson_Person.size())), "http://www.oop.org/relationpwp/");
				break;
			case 1:
				ent1 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				ent2 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				relas = inst.addRela(rePerson_Event.get((int)(Math.random()*rePerson_Event.size())), "http://www.oop.org/relationpwe/");
				break;
			case 2:
				ent1 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				ent2 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				relas = inst.addRela(rePerson_Location.get(rnd.nextInt(rePerson_Location.size())), "http://www.oop.org/relationpwl/");
				break;
			case 3:
				ent1 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				ent2 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				relas = inst.addRela(rePerson_Organization.get(rnd.nextInt(rePerson_Organization.size())), "http://www.oop.org/relationpwo/");
				break;
			case 4:
				ent1 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				ent2 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				relas = inst.addRela(rePerson_Country.get((int)(Math.random()*rePerson_Country.size())), "http://www.oop.org/relationpwc/");
				break;
			case 5:
				ent1 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				ent2 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				relas = inst.addRela(reEvent_Person.get((int)(Math.random()*reEvent_Person.size())), "http://www.oop.org/relationewp/");
				break;
			case 6:
				ent1 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				ent2 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				relas = inst.addRela(reEvent_Event.get((int)(Math.random()*reEvent_Event.size())), "http://www.oop.org/relationewe/");
				break;
			case 7:
				ent1 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				ent2 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				relas = inst.addRela(reEvent_Location.get(rnd.nextInt(reEvent_Location.size())), "http://www.oop.org/relationewl/");
				break;
			case 8:
				ent1 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				ent2 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				relas = inst.addRela(reEvent_Organization.get(rnd.nextInt(reEvent_Organization.size())), "http://www.oop.org/relationewo/");
				break;
			case 9:
				ent1 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				ent2 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				relas = inst.addRela(reEvent_Country.get((int)(Math.random()*reEvent_Country.size())), "http://www.oop.org/relationewc/");
				break;
			case 10 :
				ent1 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				ent2 = ListTime.get(rnd.nextInt(ListTime.size()));
				relas = inst.addRela(reEvent_Time.get((int)(Math.random()*reEvent_Time.size())), "http://www.oop.org/relationewt/");
				break;
			case 11:
				ent1 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				ent2 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				relas = inst.addRela(reOrganization_Person.get((int)(Math.random()*reOrganization_Person.size())), "http://www.oop.org/relationowp/");
				break;
			case 12:
				ent1 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				ent2 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				relas = inst.addRela(reOrganization_Event.get((int)(Math.random()*reOrganization_Event.size())), "http://www.oop.org/relationowe/");
				break;
			case 13:
				ent1 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				ent2 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				relas = inst.addRela(reOrganization_Location.get(rnd.nextInt(reOrganization_Location.size())), "http://www.oop.org/relationowl/");
				break;
			case 14:
				ent1 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				ent2 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				relas = inst.addRela(reOrganization_Organization.get(rnd.nextInt(reOrganization_Organization.size())), "http://www.oop.org/relationowo/");
				break;
			case 15:
				ent1 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				ent2 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				relas = inst.addRela(reOrganization_Country.get((int)(Math.random()*reOrganization_Country.size())), "http://www.oop.org/relationowc/");
				break;
			case 16 :
				ent1 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				ent2 = ListTime.get(rnd.nextInt(ListTime.size()));
				relas = inst.addRela(reOrganization_Time.get((int)(Math.random()*reOrganization_Time.size())), "http://www.oop.org/relationeowt/");
				break;
			case 17:
				ent1 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				ent2 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				relas = inst.addRela(reLocation_Person.get((int)(Math.random()*reLocation_Person.size())), "http://www.oop.org/relationlwp/");
				break;
			case 18:
				ent1 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				ent2 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				relas = inst.addRela(reLocation_Event.get((int)(Math.random()*reLocation_Event.size())), "http://www.oop.org/relationlwe/");
				break;
			case 19:
				ent1 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				ent2 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				relas = inst.addRela(reLocation_Location.get(rnd.nextInt(reLocation_Location.size())), "http://www.oop.org/relationlwl/");
				break;
			case 20:
				ent1 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				ent2 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				relas = inst.addRela(reLocation_Organization.get(rnd.nextInt(reLocation_Organization.size())), "http://www.oop.org/relationlwo/");
				break;
			case 21:
				ent1 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				ent2 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				relas = inst.addRela(reLocation_Country.get((int)(Math.random()*reLocation_Country.size())), "http://www.oop.org/relationlwc/");
				break;
			case 22:
				ent1 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				ent2 = ListPerson.get(rnd.nextInt(ListPerson.size()));
				relas = inst.addRela(reCountry_Person.get((int)(Math.random()*reCountry_Person.size())), "http://www.oop.org/relationcwp/");
				break;
			case 23:
				ent1 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				ent2 = ListEvent.get(rnd.nextInt(ListEvent.size()));
				relas = inst.addRela(reCountry_Event.get((int)(Math.random()*reCountry_Event.size())), "http://www.oop.org/relationcwe/");
				break;
			case 24:
				ent1 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				ent2 = ListLocation.get(rnd.nextInt(ListLocation.size()));
				relas = inst.addRela(reCountry_Location.get(rnd.nextInt(reCountry_Location.size())), "http://www.oop.org/relationcwl/");
				break;
			case 25:
				ent1 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				ent2 = ListOrganization.get(rnd.nextInt(ListOrganization.size()));
				relas = inst.addRela(reCountry_Organization.get(rnd.nextInt(reCountry_Organization.size())), "http://www.oop.org/relationcwo/");
				break;
			case 26:
				ent1 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				ent2 = ListCountry.get(rnd.nextInt(ListCountry.size()));
				relas = inst.addRela(reCountry_Country.get((int)(Math.random()*reCountry_Country.size())), "http://www.oop.org/relationcwc/");
				break;	
			default:
				break;
			}
			inst.addRelastt(ent1, relas, ent2);
		}
	}

	
}
