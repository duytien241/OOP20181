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
	public static void main(String[] args) throws Exception {
		SaveDB ins = new SaveDB();
		long startTime = System.currentTimeMillis();
		ins.GenEntity(1000);
		System.out.println("Ok");
		ins.GenRela(2000);
		System.out.println("Ok2");

		
	
	}
	
}
