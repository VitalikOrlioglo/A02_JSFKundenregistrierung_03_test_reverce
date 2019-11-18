package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * Aufgabe: als Singleton implementieren
 * Connetion zur Datenbank herstellen
 * 
 * cimadata Java 2
 * @author micha schirmer 
 * 09.10.2019
 * A01_fx_StudentenDB
 *
 */
public final class DBConnect {
	
	private final String URL ="jdbc:mysql://localhost:3306/java3";
	
	private static DBConnect instance =null;
	
	private Connection con;
	
	private DBConnect() {
		try {
			// jdbc class forname
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // ab Java7 muss man nicht explizit Triber laden, aber JavaEE-WebContainer(Tomcat) benotigt Treiber explizit laden
			con = DriverManager.getConnection(URL, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static DBConnect getInstance() {
		if(instance==null) {
			instance = new DBConnect();
		}
		
		return instance;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
