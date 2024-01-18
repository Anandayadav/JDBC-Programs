import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SelectFetchSize {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","andb","andb");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from mobile");
			while (rs.next()) {
			for (int i=1; i<rs.getFetchSize(); i++) { //getFetchsize() is used for The size of column , but it shows one less column. therefore add 1. 
				System.out.println(rs.getString(i));
			}
			}
		} 
		catch (Exception e) {
			System.out.println(e);		
			}
	}
}
