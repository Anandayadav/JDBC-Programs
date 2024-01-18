import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateMobile {

	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Statement stmt=con.createStatement();
	int i=stmt.executeUpdate("Update Mobile set Model_name='Y-21' where model_no=21");
	System.out.println(i+"Updation happenned");
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}

	}
}
