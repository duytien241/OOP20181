package App;

import java.io.IOException;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import backend.InsertDB;


public class Application {
	static RepositoryConnection connection= null;
	public static String Query1() {
		String queryString = "PREFIX label:<http://www.oop.org/> \n";
		queryString += "PREFIX person:<http://www.oop.org/person/> \n";
		queryString += "SELECT ?s ?p ?o \n";
	    queryString += "WHERE { ?s ?p ?o .\n";
		queryString += " FILTER (?s =person:person1 && ?p =label:Label)";
		queryString += "}";
		return queryString;
	}
	public static void main(String[] args) throws IOException {
		InsertDB ins = new InsertDB();
//		ins.GenEntity(1000);
//		System.out.println("Ok");
//		ins.GenRela(2000);
//		System.out.println("Ok2");
		connection = backend.ConnectDB.getRepositoryConnection();
		String query = Query1();
		TupleQuery tupleQuery = connection.prepareTupleQuery(query);
		TupleQueryResult result = tupleQuery.evaluate();
		while (result.hasNext()) {
			BindingSet bind = result.next();
			Value s = bind.getValue("s");
			Value p = bind.getValue("p");
			Value o = bind.getValue("o");
			System.out.format("s: %s p: %s o: %s\n");
		
		}
		System.out.println("Ok2");
	
	}

}
