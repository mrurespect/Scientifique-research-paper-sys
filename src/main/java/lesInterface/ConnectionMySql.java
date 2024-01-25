package lesInterface;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySql {


	private static Connection conn;
	  static {
		 
	  try { Class.forName("com.mysql.cj.jdbc.Driver");
	  
	  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavadata","root","");  
}
	  catch(Exception e){ System.out.println("Erreur lors du chargement de Driver:"+e);}
	 }
	  public static Connection getConnection(){return conn;}

}
