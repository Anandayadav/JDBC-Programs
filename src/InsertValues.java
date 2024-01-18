import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class InsertValues {

		public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			Statement stmt=con.createStatement();
		int i=stmt.executeUpdate("insert into student values(104,'Archana','Bengaluru')");
		System.out.println(i+"  values are inseted successfully");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}