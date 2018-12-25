package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import virtuoso.rdf4j.driver.VirtuosoRepository;

public class ConnectDB {
	private static final String URL = "jdbc:virtuoso://localhost:1111/charset=UTF-8/log_enable=0";
	private static final String USERNAME = "dba";
	private static final String PASSWORD = "dba";
	private static RepositoryConnection con;
	
	
	public static ValueFactory getConnection() {
		Repository repository = new VirtuosoRepository(URL, USERNAME, PASSWORD);
		con = repository.getConnection();
		ValueFactory vf = con.getValueFactory();
		
		return vf;
	}
	public static Connection getc() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:virtuoso://localhost:1111/",USERNAME, PASSWORD);
		return conn;
		
	}
	public static RepositoryConnection getRepositoryConnection() {
		Repository repository = new VirtuosoRepository(URL, USERNAME, PASSWORD);
		con = repository.getConnection();

		return con;
	}
	
	
}
