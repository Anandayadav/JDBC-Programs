
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Insertbook{

	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the values of bid,bname,isbn,price,author,publiser,publyear,bedition");
		int bid=sc.nextInt();
		String bname=sc.next();
		int isbn_no=sc.nextInt();
		double price=sc.nextDouble();
		String aut_name=sc.next();
		String pblsName=sc.next();
		int Pblsyear=sc.nextInt();
		int bedition=sc.nextInt();
		PreparedStatement ps=con.prepareStatement("insert into Book values(?,?,?,?,?,?,?,?)");
		System.out.println("OK");
		ps.setInt(1, bid);
		ps.setString(2,bname);
		ps.setInt(3,isbn_no);
		ps.setDouble(4, price);
		ps.setString(5, aut_name);
		ps.setString(6,pblsName);
		ps.setInt(7, Pblsyear);
		ps.setInt(8, bedition);
	
	int i=ps.executeUpdate();
	System.out.println(i+"Inserted successfully");
	con.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}

}
