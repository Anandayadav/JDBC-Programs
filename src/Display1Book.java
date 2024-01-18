
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Display1Book{

	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		System.out.println("Enter the value of bid you want to delete");
		Statement  stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from book where bid=104");
		if(rs.next())
		{
			for (int i = 1; i <rs.getFetchSize()-1; i++) {
				System.out.println(rs.getString(i));
			}
			
		}
		
				

	
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}
