package backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import com.fasterxml.jackson.databind.Module;

import enity.Country;
import enity.Event;
import enity.Location;
import enity.Organization;
import enity.Person;
import enity.Time;
import virtuoso.rdf4j.driver.VirtuosoRepository;


public class InsertData {
	public String NAMESPACE = "http://www.oop.org/";
	public String personNamespace = "http://www.oop.org/person/";
	public String organizationNamespace = "http://www.oop.org/organization/";
	public String locationNamespace = "http://www.oop.org/location/";
	public String countryNamespace = "http://www.oop.org/country/";
	public String timeNamespace = "http://www.oop.org/time/";
	public String eventNamespace = "http://www.oop.org/event/";
	private Model model;
	private RepositoryConnection con;
	ValueFactory vf;
	//IRI entity
	protected IRI PERSON;
	protected IRI COUNTRY;
	protected IRI LOCATION;
	protected IRI EVENT;
	protected IRI ORGANIZATION;
	protected IRI RELATIONSHIP;
	protected IRI TIME;
	private IRI HAS_NAME;
	private IRI HAS_DESCRIPTION;
	private IRI HAS_LINK;
	private IRI HAS_DATE;
	private IRI HAS_SEX;
	private IRI HAS_AGE;
	private IRI HAS_JOB;
	private IRI label;
	private Literal describe;
	private Literal name;
	private Literal link;
	private Literal date;
	private Literal sex;
	private Literal age;
	private Literal job;
	
	public InsertData() {
		vf =  ConnectDB.getConnection();
		con = ConnectDB.getRepositoryConnection();
		PERSON = vf.createIRI(NAMESPACE, "Person");
		COUNTRY = vf.createIRI(NAMESPACE, "Country");
		LOCATION = vf.createIRI(NAMESPACE, "Location");
		ORGANIZATION = vf.createIRI(NAMESPACE, "Organization");
		EVENT = vf.createIRI(NAMESPACE, "Event");
		TIME = vf.createIRI(NAMESPACE, "TIME");
		HAS_NAME = vf.createIRI(NAMESPACE, "Label");
		HAS_DESCRIPTION = vf.createIRI(NAMESPACE, "Describe");
		HAS_LINK = vf.createIRI(NAMESPACE, "Link");
		HAS_DATE = vf.createIRI(NAMESPACE, "Date");
		HAS_AGE =vf.createIRI(NAMESPACE, "Age");
		HAS_JOB =vf.createIRI(NAMESPACE, "Job");
		HAS_SEX = vf.createIRI(NAMESPACE,"Sex");
		model = new TreeModel();
		
	}
	public IRI addEntity(Person p) {
		IRI tmp = vf.createIRI(personNamespace,p.getLabel());
		name = vf.createLiteral(p.getName());
		describe = vf.createLiteral(p.getDescribe());
		link = vf.createLiteral(p.getLink());
		date = vf.createLiteral(p.getDate());
		sex = vf.createLiteral(p.getMale());
		age = vf.createLiteral(p.getAge());
		job = vf.createLiteral(p.getJob());
		model.add(tmp, RDF.TYPE,PERSON);
		model.add(tmp,HAS_NAME,name);
		model.add(tmp,HAS_DESCRIPTION,describe);
		model.add(tmp,HAS_LINK,link);
		model.add(tmp,HAS_DATE,date);
		model.add(tmp,HAS_SEX,sex);
		model.add(tmp,HAS_AGE,age);
		model.add(tmp,HAS_JOB,job);
		con.add(model);
		
		return tmp;
	}
	public IRI addEntity(Location l) {
		IRI tmp = vf.createIRI(locationNamespace,l.getLabel());
		name = vf.createLiteral(l.getName());
		describe = vf.createLiteral(l.getDescribe());
		link = vf.createLiteral(l.getLink());
		date = vf.createLiteral(l.getDate());
		model.add(tmp, RDF.TYPE,LOCATION);
		model.add(tmp,HAS_NAME,name);
		model.add(tmp,HAS_DESCRIPTION,describe);
		model.add(tmp,HAS_LINK,link);
		model.add(tmp,HAS_DATE,date);
		con.add(model);
		return tmp;
	}
	public IRI addEntity(Organization o) {
		IRI tmp = vf.createIRI(organizationNamespace,o.getLabel());
		name = vf.createLiteral(o.getName());
		describe = vf.createLiteral(o.getDescribe());
		link = vf.createLiteral(o.getLink());
		date = vf.createLiteral(o.getDate());
		model.add(tmp, RDF.TYPE,ORGANIZATION);
		model.add(tmp,HAS_NAME,name);
		model.add(tmp,HAS_DESCRIPTION,describe);
		model.add(tmp,HAS_LINK,link);
		model.add(tmp,HAS_DATE,date);
		con.add(model);
		return tmp;
	}
	public IRI addEntity(Time t) {
		IRI tmp = vf.createIRI(timeNamespace,t.getLabel());
		name = vf.createLiteral(t.getName());
		describe = vf.createLiteral(t.getDescribe());
		link = vf.createLiteral(t.getLink());
		date = vf.createLiteral(t.getDate());
		model.add(tmp, RDF.TYPE,TIME);
		model.add(tmp,HAS_NAME,name);
		model.add(tmp,HAS_DESCRIPTION,describe);
		model.add(tmp,HAS_LINK,link);
		model.add(tmp,HAS_DATE,date);
		con.add(model);
		return tmp;
	}
	public IRI addEntity(Event e) {
		IRI tmp = vf.createIRI(eventNamespace,e.getLabel());
		name = vf.createLiteral(e.getName());
		describe = vf.createLiteral(e.getDescribe());
		link = vf.createLiteral(e.getLink());
		date = vf.createLiteral(e.getDate());
		model.add(tmp, RDF.TYPE,EVENT);
		model.add(tmp,HAS_NAME,name);
		model.add(tmp,HAS_DESCRIPTION,describe);
		model.add(tmp,HAS_LINK,link);
		model.add(tmp,HAS_DATE,date);
		con.add(model);
		return tmp;
	}
	public IRI addEntity(Country c) {
		IRI tmp = vf.createIRI(countryNamespace,c.getLabel());
		name = vf.createLiteral(c.getName());
		describe = vf.createLiteral(c.getDescribe());
		link = vf.createLiteral(c.getLink());
		date = vf.createLiteral(c.getDate());
		model.add(tmp, RDF.TYPE,COUNTRY);
		model.add(tmp,HAS_NAME,name);
		model.add(tmp,HAS_DESCRIPTION,describe);
		model.add(tmp,HAS_LINK,link);
		model.add(tmp,HAS_DATE,date);
		con.add(model);
		return tmp;
	}
	
	public IRI addRela(String des, String namespace ) {
		 return vf.createIRI(namespace,des);
	}
	public void addRelastt(IRI entity1, IRI relationship, IRI entity2 ) {
		model.add(entity1, relationship, entity2);
		con.add(model);
	
	}
	public Model getModel() {
		return model;
	}
	
}
