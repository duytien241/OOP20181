package backend;

public class QuerySimple {
	//in ra tên của person
	public static String query2 = "prefix person: <http://www.oop.org/person/>  " + 
			"prefix oop: <http://www.oop.org/>  " + 
			"   " + 
			"select ?person ?dinhdanh ?age ?mota ?gioitinh ?ngaytrichrut ?nguontrichrut where {  " + 
			" 	?x oop:Label ?dinhdanh. " + 
			"    ?x oop:Age ?age. " + 
			"    ?x oop:Describe ?mota.  " + 
			"    ?x oop:SEX ?gioitinh.  " + 
			"    ?y oop:Date ?ngaytrichrut.  " + 
			"    ?y oop:Link ?nguontrichrut.  " + 
			"    filter(?age = 47)  " + 
			"}";
	
	public static String Query1() {
		String queryString = "PREFIX label:<http://www.oop.org/> \n";
		queryString += "PREFIX person:<http://www.oop.org/person/> \n";
		queryString += "SELECT ?s ?p ?o \n";
	    queryString += "WHERE { ?s ?p ?o .\n";
		queryString += " FILTER (?s =person:person480 )";
		queryString += "}";
		return queryString;
	}
	public static String Query2(String nameCountry) {
		String queryString = "prefix person:<http://www.oop.org/person/>\n"
				+ "select ?o\n"
				+ "where{\n"
				+ "?s person:nationality ?t.\n"
				+ "?s person:Label ?o\n"
				+ "filter regex (?t, \"" + nameCountry +"\")\n"
				+ "}";
		return queryString;
	}
}
