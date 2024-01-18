
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class UpdateBook{

	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the values of bid,pblsyear");
		int bid=sc.nextInt();
		int pbyear=sc.nextInt();
		PreparedStatement ps=con.prepareStatement("update book set bid=? where PBLSYEAR=?");
		
		ps.setInt(1, bid);
		ps.setInt(2, pbyear);
	
	int i=ps.executeUpdate();
	System.out.println(i+"Updated successfully");
	con.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}

}
