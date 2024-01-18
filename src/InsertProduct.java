import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertProduct{
public static void main(String[] args) {
	
	try {
		int total=0;
		double inbill=0;
		double discount=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the values of pid,pname,price,quantity,total,discount,gst,invoice bill");
		int pid=sc.nextInt();
		String pname=sc.next();
		int price=sc.nextInt();
		int quantity=sc.nextInt();
		total=price*quantity;
		if(total<2500) {
			discount=0.05*total;
		}
		else if (total>2500 && total<5000) {
			discount=0.15*total;
		} else {
			
			discount=0.25*total;
		}
		inbill=total-discount;
		double gst=0.18*inbill;
		
		
		double invbill=inbill+gst;
		PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?,?,?,?)");
		System.out.println("OK");
		ps.setInt(1, pid);
		ps.setString(2,pname);
		ps.setDouble(3, price);
		ps.setInt(4, quantity);
		ps.setDouble(5,total);
		ps.setDouble(6, discount);
		ps.setDouble(7, gst);
		ps.setDouble(8, invbill);
	
	int i=ps.executeUpdate();
	System.out.println(i+"Inserted successfully");
	con.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}