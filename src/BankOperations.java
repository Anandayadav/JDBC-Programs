
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class BankOperations{

	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Scanner sc=new Scanner(System.in);
		double oldbal=0.0;
		PreparedStatement ps=con.prepareStatement("select * from account where acc_no=?");
		System.out.println("Enter the account number from which you want to withdraw");
		int accno=sc.nextInt();
		ps.setInt(1, accno);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			oldbal=rs.getDouble(2);
		System.out.println("old bal is"+oldbal);
		}
		System.out.println("Enter the amount you want to withdraw");
		double withdraw=sc.nextDouble();
		double fin_balance=oldbal-withdraw;
		
		System.out.println(fin_balance);
		if(withdraw<oldbal)
		{
			PreparedStatement ps2=con.prepareStatement("update account set balance=? where acc_no=?");
			
			
			ps2.setDouble(1, fin_balance);
			
			ps2.setInt(2, accno);
			System.out.println("ok");
			ps2.executeUpdate();
		}
		else
		{
			System.out.println("You have insufiicent balance");
		}
		System.out.println("Operation successfull");
	
	con.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}

}
