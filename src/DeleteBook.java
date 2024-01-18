
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class DeleteBook{

	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of bid you want to delete");
		int bid=sc.nextInt();
		PreparedStatement ps=con.prepareStatement("delete from book where bid=?");
		System.out.println("OK");
		
		ps.setInt(1, bid);
	
	int i=ps.executeUpdate();
	System.out.println(i+"Deleted successfully");
	con.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}
