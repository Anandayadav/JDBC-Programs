import java.sql.*;
import java.util.Scanner;
public class BankDeposite {

	public static void main(String[] args) {
		try {
			double oldbal=0.0,deposit=0.0,totalbal=0.0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			PreparedStatement ps=con.prepareStatement("select balance from account where acc_no=?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the account number to which you want to  deposite");
			int accno=sc.nextInt();
			ps.setInt(1, accno);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				oldbal=rs.getDouble(1);
				System.out.println("ok");
			}
			System.out.println("Old balance is"+oldbal);
			System.out.println("Enter the amount you want to deposite");
			deposit=sc.nextDouble();
			totalbal=oldbal+deposit;
			
			PreparedStatement ps2=con.prepareStatement("update account set balance=? where acc_no=?");
			ps2.setDouble(1, totalbal);
			ps2.setInt(2, accno);
			ps2.executeUpdate();
			
			con.close();
			System.out.println("updated successfully");
			
		} catch (Exception e) {
			System.out.println(e);
		}


	}

}
