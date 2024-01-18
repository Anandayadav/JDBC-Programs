import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertMobValues {

	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Statement stmt=con.createStatement();
	int i=stmt.executeUpdate("insert into Mobile values(16,'REALME','4GB','64GB','Android','Android_5.0',12663666881355,'16MP','32MP',25000)");
	System.out.println(i+"  values are inseted successfully");
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}

	}

}
