import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class AlterTableMobile {
		public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			Statement stmt=con.createStatement();
		int i=stmt.executeUpdate("Alter table Mobile add(Model_name varchar2(5))");
		System.out.println(i+"  Table altered");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
