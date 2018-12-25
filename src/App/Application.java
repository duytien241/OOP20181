package App;

import java.io.IOException;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import backend.SaveDB;


public class Application {
	static RepositoryConnection connection= null;
	public static void main(String[] args) throws Exception {
//		SaveDB ins = new SaveDB();
//		long startTime = System.currentTimeMillis();
//		ins.GenEntity(1000);
//		System.out.println("Ok");
//		ins.GenRela(2000);
//		System.out.println("Ok2");

		long begin = System.currentTimeMillis();
		connection = backend.ConnectDB.getRepositoryConnection();
		String query = backend.QuerySimple.Query1();
		TupleQuery tupleQuery = connection.prepareTupleQuery(query);
		TupleQueryResult result = tupleQuery.evaluate();
		while (result.hasNext()) {
			BindingSet bind = result.next();
//			String d = bind.getValue("person").toString();
//			String s = bind.getValue("dinhdanh").toString();
//			String p = bind.getValue("age").toString();
//			String o = bind.getValue("mota").toString();
			String s = bind.getValue("s").toString();
			String p = bind.getValue("p").toString();
			String o = bind.getValue("o").toString();
			System.out.println(s+": " +p +":" +o);
		
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time query: " + (endTime - begin) );
	
	}
	
}
