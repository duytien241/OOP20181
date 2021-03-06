package backend;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

public class Query {
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
	    	+ "WHERE { ?pe label:Label ?s. ?pe label:Age ?p. ?pe label:Sex ?o."
	    	+ " FILTER (?p = 47)"
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
			//Đếm sự kiện vào năm 2017
			public static String query11 = "prefix enti: <http://www.oop.org/event/>  " + 
					"prefix re: <http://www.oop.org/relationewl/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT count(?s) as ?s where {  " + 
					" ?eve	lc:Label ?s ."+
					" ?eve  lc:Link ?p. "+
					" ?eve 	lc:Date ?o." + 
					
				//	"filter( ?p = re:dien_ra_tai)  " +
					"filter regex(?o ,\"2017\") "+
					"}";
			//in ra China đã tổ chức bao nhiêu event vào 2017
			public static String query12 = "prefix enti: <http://www.oop.org/event/>  " + 
					"prefix re: <http://www.oop.org/relationcwe/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT count(?s) as ?s where {  " + 
					"?s rdf:type label:Country .\n"+
					"?s label:Label ?name ."+
					"filter regex(?name,\"China\""+
					"?s re:to_chuc ?event"+
					"?event re:vao ?t"+
					"filter regex(?t ,\"2017\") "+
					"}";
			// in  ra sự kiện XXX tổ chức ở đâu vào thời điểm nào
			public static String query13 ="prefix enti: <http://www.oop.org/event/>  " + 
					"prefix re: <http://www.oop.org/relationewt/>  " + 
					"prefix re2: <http://www.oop.org/relationewl/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT ?name ?time ?taidau where {  " + 
					"?s rdf:type label:Event .\n"+
					"?s label:Label ?name ."+
					"filter regex(?name,\"XXX\""+
					"?s re:to_chuc ?event"+
					"?event re:vao ?time"+
					"?event re2:dien_ra_tai ? location2"+
					"?location2 lc:Label ?taidau"+
					"}";
			//China đang truy sát ai
			public static String query14 = "prefix enti: <http://www.oop.org/country/>  " + 
					"prefix re: <http://www.oop.org/relationcwp/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT ?s ?p ?o where {  " + 
					"?cou rdf:type lc:Country."+
					" ?cou lc:Label ?s. " +
				
					"   ?cou ?p ?org."+
					" 	?org lc:Label ?o. " +
					"filter( ?p = re:truy_sat)  " + 
					"filter regex( ?s , \"China\")  " + 
					"}";
			// đưa ra con của Janenna Dangl  
			public static String query15 = "prefix enti: <http://www.oop.org/person/>  " + 
				"prefix re: <http://www.oop.org/relationpwp/>  " + 
				"prefix lc: <http://www.oop.org/>  " + 
				"   " + 
				"select  DISTINCT ?s ?p ?o where {  " + 
				"?cou rdf:type lc:Person."+
				" 	?cou lc:Label ?a. " +
				"   ?cou ?qh ?org."+
				" 	?org lc:Label ?s. " +
				"	?org lc:Age ?o."+
				" ?org lc:Describe ?p."+
				"filter( ?qh = re:bo)  " + 
				"filter regex(?a,\"Janenna Dangl\")"+
				"filter (?o> 20)"+
				"}";
			// dưa ra con của Janenna Dangl  có tuổi lớn hơn 20 và làm nhân viên ở đâu
			public static String query16 = "prefix enti: <http://www.oop.org/person/>  " + 
					"prefix re: <http://www.oop.org/relationpwp/>  " + 
					"prefix re2: <http://www.oop.org/relationpwo/>  " + 
					"prefix lc: <http://www.oop.org/>  " + 
					"   " + 
					"select  DISTINCT ?s ?p ?o where {  " + 
					"?cou rdf:type lc:Person."+
					"   ?cou ?qh ?org."+
					" 	?org lc:Label ?s. " +
					"	?org lc:Age ?a."+
					" ?org lc:Describe ?p."+
					" ?org ?qh2 ?com."+
					" ?com lc:Label ?o."+
					"filter (?qh2 =re2:nhan_vien)"+
					"filter( ?qh = re:bo)  " + 
					"filter regex(?a,\"Janenna Dangl\")"+
					"filter (?a > 20)"+
					"}";
			//  International Exhibition Von Inc do ai tổ chức, người đó thuộc tổ chức nào, tổ chức đó thành lập năm bao nhiêu?
			public static String query17 = "PREFIX re:<http://www.oop.org/relationowp/> \n"+
					"PREFIX re2:<http://www.oop.org/person/relationpwo/> \n"+
					"PREFIX re3:<http://www.oop.org/person/relationowt/> \n"+
					"PREFIX label:<http://www.oop.org/> \n" + 
					 "SELECT ?s ?p ?o ?a ?b ?c ?t\n"+
					 "WHERE { \n"+
					 " ?eve label:Label ?s .\n" +
					 " ?eve ?p ?per .\n"+
					 " FILTER (?p = re:to_chuc_boi)" +
					 "?per label:Label ?o .\n"+
					 "?per ?a ?org .\n"+
					 " FILTER (?a = re2:lam_viec_tai)" + 
					 " ?org label:Label ?b .\n"+
					 " ?org ?c ?time .\n"+
					 " FILTER (?c = re3:thanh_lap_tai)"+
					 " ?time label:label ?t .\n"+
					 " FILTER regex(?s, \"IVon Inc\") "+
					"}";
			//In ra những người tham dự sự kiện Seamless Vietnam nhưng không tham dự VietFood
			public static String query18 =  "PREFIX re:<http.www.oop.org/relationpwe/> \n"+
			"PREFIX person:<http://www.oop.org/person/> \n"+
			"PREFIX label:<http://www.oop.org/> \n"+
			"SELECT ?o \n"+
		    "WHERE { \n"+
			"?x label:Label ?o."+
			" ?x ?p ?s .\n"+
			" ?s label:Label ?a .\n" +
			" FILTER regex(?p, \"tham_gia\")"  +
			" FILTER regex (?a , \"Seamless Vietnam\")" +
			" FILTER (?a != \"VietFood\"^^<http://www.w3.org/2001/XMLSchema#string>)" +
			 "}";	
			//Location China đầu tư cho bao nhiêu tổ chức
			public static String query19 = "PREFIX label:<http://www.oop.org/> \n"+
				"PREFIX re:<http.www.oop.org/relationcwo/> \n"+
				"SELECT count(?s) as ?o \n"+
			    "WHERE {"+
			    "?s rdf:type label:Country .\n"+
			    "?s label:Label ?name .\n"+
			    " FILTER regex(?name, \"China\")"+
			    "?s ?qh ?c .\n"+
			    " FILTER regex(?qh, \"dau_tu\")"+
				"}";
			// 10 chi tiet Event do tổ chức nào chủ trì thời gian nào diễn ra ?
			public static String query20= "PREFIX re:<http://www.oop.org/relationowe/> \n" +
					"PREFIX re2:<http://www.oop.org/relationewt/> \n" +
			"PREFIX label:<http://www.oop.org/> \n" +
			"SELECT ?s ?p ?o ?t\n" +
		    "WHERE { \n" +
		    " ?event label:Label ?s .\n" +
			" ?event ?p ?org .\n"+
			" ?event ?q ?time .\n"+
			" ?org label:Label ?o .\n" +
			" ?time label:Label ?t .\n" +
		//	" FILTER (?p =re:to_chuc && ?q = re2:vao)" +
			"}" +
			" LIMIT 10";
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
	//3 tham so
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
			System.out.printf( "s: %s, p : %s, o : %s\n",p,l,d);
		
//		
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time query: " + (endTime - begin) );
	}
	//2 tham số
	public static void ketqua5(String query) {
		long begin = System.currentTimeMillis();
		connection = backend.ConnectDB.getRepositoryConnection();
		TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL,query);
		TupleQueryResult result = tupleQuery.evaluate();
		while (result.hasNext()) {
			BindingSet bind = result.next();
			String p = bind.getValue("s").stringValue();
			String l = bind.getValue("p").stringValue();
			
			System.out.printf( "s : %s, p : %s\n",p,l);
		
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
			String s = bind.getValue("o").stringValue();
			System.out.printf( "KQ: %s\n",s);
		
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time query: " + (endTime - begin) );
	}
	public static void main (String args[]){

		ketqua2(query20);
	}
	
}
