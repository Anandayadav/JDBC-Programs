import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEleBill{
public static void main(String[] args) {
	
	try {
		int units=0;
		double rate=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the values of cid,cname,currreading,previReading");
		int cid=sc.nextInt();
		String cname=sc.next();
		int currread=sc.nextInt();
		int prevread=sc.nextInt();
		units=currread-prevread;
		if(units<300) {
			rate=1.75*units;
		}
		else if (units>=300 && units<700) {
			rate=5.75*units;
		} else {
			
			rate=7.25*units;
		}
		double totalbill=rate;
		
		PreparedStatement ps=con.prepareStatement("insert into ElectricityBill values(?,?,?,?,?,?)");
		System.out.println("OK");
		ps.setInt(1, cid);
		ps.setString(2,cname);
		ps.setInt(3, currread);
		ps.setInt(4, prevread);
		ps.setDouble(5,units);
		ps.setDouble(6, totalbill);
		
	int i=ps.executeUpdate();
	System.out.println(i+"Inserted successfully");
	con.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}