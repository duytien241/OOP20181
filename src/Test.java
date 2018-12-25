import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
public static void main(String[] args) throws SQLException {

Connection conn = backend.ConnectDB.getc();
String sql = "SELECT P,S,O,G FROM DB.DBA.RDF_QUAD";
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(sql);
while (rs.next()) {
System.out.print("S:" +rs.getString(1));
System.out.print("S:" +rs.getString(3));
System.out.print("S:" +rs.getString(4));
System.out.print(" P: " +rs.getString(2)+"\n");
}
}
}