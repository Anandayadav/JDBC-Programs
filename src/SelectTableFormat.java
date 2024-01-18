import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTableFormat {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from Student");
			System.out.println("--------------------------------------------------------------");
			System.out.println("   Sid    | SName    |Saddress   |");
			System.out.println("--------------------------------------------------------------");

			while (rs.next()) {
				int i=rs.getInt("Sid");
				String n=rs.getString("Sname");
				String a=rs.getString("Saddress");
			System.out.printf("| %-10d | %-10s | %-10s |\n", i, n, a);
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
