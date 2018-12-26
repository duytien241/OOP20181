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
			"    ?label oop:Sex ?gioitinh.  " + 
			"    ?label oop:Date ?ngaytrichrut.  " + 
			"    ?label oop:Link ?link.  " + 
			"    filter(?label = person:person1)  " + 
			"}";
	// in thông tin của  những người 47 tuổi
	public static String query2 = "PREFIX label:<http://www.oop.org/> \n"+
			"PREFIX person:<http://www.oop.org/event/> \n"
			+ "SELECT ?s ?p ?o \n"
	    	+ "WHERE { ?s ?p ?o .\n"
	    	+ " FILTER regex(?s,\"event\")"
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
				"    filter(?label = event:event2)  " + 
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
		// in ra địa chỉ của Nancie Lyttle
			public static String query7 = "prefix enti: <http://www.oop.org/person/>  " + 
					"prefix re: <http://www.oop.org/relationpwl/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT ?s ?p ?o where {  " + 
					" 	?x lc:Label ?s. " + 
					" 	?x ?p ?country. " + 
					"    ?country lc:Label ?o.  " + 
					" FILTER regex(?s, \"Nancie Lyttle\") "+
					"    filter( ?p = re:dia_chi)  " + 
					"}";
		// in ra tên 10 person
			public static String query8 = "prefix enti: <http://www.oop.org/person/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT ?s where {  " + 
					" 	?x lc:Label ?s. " + 
					"    filter regex(str(?x), \"person\") " + 
					"}" +
					"LIMIT 10";
			// in ra địa chỉ của các person
			public static String query9 = "prefix enti: <http://www.oop.org/person/>  " + 
					"prefix re: <http://www.oop.org/relationpwl/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT ?s ?p ?o where {  " + 
					" 	?s ?p ?o. " + 
					" FILTER regex(?s ,\"person\") "+
					"filter( ?p = re:dia_chi)  " + 
					"}";
			// in ra các sự kiện mà các person tham gia
			public static String query10 = "prefix enti: <http://www.oop.org/person/>  " + 
					"prefix re: <http://www.oop.org/relationpwe/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT ?s ?p ?o where {  " + 
					" 	?s ?p ?o. " + 
					" FILTER regex(?s ,\"person\") "+
					"filter( ?p = re:toi_tham)  " + 
					"}";
			//Những sự kiện tổ chức tại 5333 Rockefeller Lane
			public static String query11 = "prefix enti: <http://www.oop.org/location/>  " + 
					"prefix re: <http://www.oop.org/relationewl/>  " + 
					"prefix label: <http://www.oop.org/>  " + 
					"   " + 
					"select  count(?s) as ?os where {  " +  
					"?s rdf:type label:Location ."+
					"?s label:label ?name .\n"+
					" FILTER regex(?name, \"5333 Rockefeller Lane\") "+
					"?s re:to_chuc_tai ?c " + 
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
	public static void ketqua2(String query) {
		long begin = System.currentTimeMillis();
		connection = backend.ConnectDB.getRepositoryConnection();
		TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL,query);
		TupleQueryResult result = tupleQuery.evaluate();
		while (result.hasNext()) {
			BindingSet bind = result.next();
			String p = bind.getValue("s").stringValue();
			String l = bind.getValue("p").stringValue();
			String d = bind.getValue("o").stringValue();
			System.out.printf( "Label : %s, Dec : %s, Date : %s\n",p,l,d);
		
//		
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time query: " + (endTime - begin) );
	}
	public static void ketqua4(String query) {
		long begin = System.currentTimeMillis();
		connection = backend.ConnectDB.getRepositoryConnection();
		TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL,query);
		TupleQueryResult result = tupleQuery.evaluate();
		while (result.hasNext()) {
			BindingSet bind = result.next();
			String s = bind.getValue("os").stringValue();
			System.out.printf( "Label : %s\n",s);
		
//		
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time query: " + (endTime - begin) );
	}
	public static void main (String args[]){

		ketqua2(query2);
	}
	
}
