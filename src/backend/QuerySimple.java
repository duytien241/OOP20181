package backend;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

public class QuerySimple {
	static RepositoryConnection connection= null;
	//in ra ra thông tin person1
	
	public static String query1 = "prefix person: <http://www.oop.org/person/>  " + 
			"prefix oop: <http://www.oop.org/>  " + 
			"   " + 
			"select  DISTINCT ?label ?dinhdanh ?age ?mota ?gioitinh ?ngaytrichrut ?link where {  " + 
			" 	?label oop:Label ?dinhdanh. " + 
			"    ?label oop:Age ?age. " + 
			"    ?label oop:Describe ?mota.  " + 
			"    ?label oop:SEX ?gioitinh.  " + 
			"    ?label oop:Date ?ngaytrichrut.  " + 
			"    ?label oop:Link ?link.  " + 
			"    filter(?label = person:person1)  " + 
			"}";
	// in thông tin của  những người 47 tuổi
	public static String query2 = "PREFIX label:<http://www.oop.org/> \n"+
			"PREFIX person:<http://www.oop.org/person/> \n"
			+ "SELECT ?s ?p ?o \n"
	    	+ "WHERE { ?s ?p ?o .\n"
	    	+ " FILTER (?p = label:Age && ?o = 47 )"
	    	+ "}";

	// đưa ra thông tin country1
	public static String query3 = "prefix country: <http://www.oop.org/country/>  " + 
			"prefix enti: <http://www.oop.org/>  " + 
			"   " + 
			"select  DISTINCT ?label ?dinhdanh ?mota ?date ?link where {  " + 
			" 	?label enti:Label ?dinhdanh. " + 
			"    ?label enti:Describe ?mota.  " + 
			"    ?label enti:Date ?date.  " + 
			"    ?label enti:Link ?link.  " + 
			"    filter(?label = country:country1)  " + 
			"}";
	//in ra thông tin location1
	public static String query4 = "prefix location: <http://www.oop.org/location/>  " + 
			"prefix enti: <http://www.oop.org/>  " + 
			"   " + 
			"select  DISTINCT ?label ?dinhdanh ?mota ?date ?link where {  " + 
			" 	?label enti:Label ?dinhdanh. " + 
			"    ?label enti:Describe ?mota.  " + 
			"    ?label enti:Date ?date.  " + 
			"    ?label enti:Link ?link.  " + 
			"    filter(?label = location:location1)  " + 
			"}";
	//in ra thông tin event
		public static String query5 = "prefix event: <http://www.oop.org/event/>  " + 
				"prefix enti: <http://www.oop.org/>  " + 
				"   " + 
				"select  DISTINCT ?label ?dinhdanh ?mota ?date ?link where {  " + 
				" 	?label enti:Label ?dinhdanh. " + 
				"    ?label enti:Describe ?mota.  " + 
				"    ?label enti:Date ?date.  " + 
				"    ?label enti:Link ?link.  " + 
				"    filter(?label = event:event1)  " + 
				"}";
		//in ra thông tin organization
				public static String query6 = "prefix org: <http://www.oop.org/organization/>  " + 
						"prefix enti: <http://www.oop.org/>  " + 
						"   " + 
						"select  DISTINCT ?label ?dinhdanh ?mota ?date ?link where {  " + 
						" 	?label enti:Label ?dinhdanh. " + 
						"    ?label enti:Describe ?mota.  " + 
						"    ?label enti:Date ?date.  " + 
						"    ?label enti:Link ?link.  " + 
						"    filter(?label = org:event1)  " + 
						"}";
	public static void ketqua1(String query) {
		long begin = System.currentTimeMillis();
		connection = backend.ConnectDB.getRepositoryConnection();
		TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL,query);
		TupleQueryResult result = tupleQuery.evaluate();
		while (result.hasNext()) {
		BindingSet bind = result.next();
		String p = bind.getValue("link").stringValue();
		String l = bind.getValue("dinhdanh").stringValue();
		String a = bind.getValue("age").stringValue();
		String d = bind.getValue("mota").stringValue();
		String s = bind.getValue("gioitinh").stringValue();
		System.out.printf("ID: %s, Label : %s, Age: %s, Dec : %s, Sex : %s\n",p,l,a,d,s);
		
//		
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time query: " + (endTime - begin) );
	}
	public static void ketqua3(String query) {
		long begin = System.currentTimeMillis();
		connection = backend.ConnectDB.getRepositoryConnection();
		TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL,query);
		TupleQueryResult result = tupleQuery.evaluate();
		while (result.hasNext()) {
			BindingSet bind = result.next();
			String p = bind.getValue("link").stringValue();
			String l = bind.getValue("dinhdanh").stringValue();
			String t = bind.getValue("date").stringValue();
			String d = bind.getValue("mota").stringValue();
			System.out.printf( "Label : %s, Dec : %s, Date : %s, Link: %s\n",l,d,t,p);
		
//		
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time query: " + (endTime - begin) );
	}
	public static void main (String args[]){

		ketqua3(query5);
	}
	
}
