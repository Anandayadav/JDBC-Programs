import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SelectWhile{
		public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Student");
		System.out.println(rs);
		while(rs.next())
		{
			for (int i = 1; i <=3; i++) {
				System.out.println(rs.getString(i));
			}
		}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}