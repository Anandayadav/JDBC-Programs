import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginStudent {

	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			Scanner sc=new Scanner(System.in);
			PreparedStatement ps=con.prepareStatement("select * from student where sid=? and sname=?");
			System.out.println("Enter the username and password");
			int sid=sc.nextInt();
			String sname=sc.next();
			ps.setInt(1, sid);
			ps.setString(2, sname);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			System.out.println("You logged in successfully");
			}
			else {
				System.out.println("Insert valid username and password");
			}
			con.close();
		} catch (Exception e) {
		System.out.println(e);
		}

	}

}
