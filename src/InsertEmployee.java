import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEmployee{
public static void main(String[] args) {
	
	try {
		Double ta=0.0,da=0.0,pf=0.0,insal=0.0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the values of eid, name,salary");
		int eid=sc.nextInt();
		String ename=sc.next();
		double salary=sc.nextDouble();
		
		if(salary<30000) {
			 ta=0.07*salary;
			 da=0.07*salary;
			 insal=salary+da;
			 pf=0.15*insal;
		}
		else if (salary>=30000 && salary<50000) {
			ta=0.12*salary;
			da=0.13*salary;
			insal=salary+da;
			pf=0.22*insal;
		} else  {
			
			ta=0.17*salary;
			da=0.19*salary;
			insal=salary+da;
			pf=0.25*insal;
		}
		
		double grosssal=salary+ta+da;
		double netsal=insal-pf;
		
		PreparedStatement ps=con.prepareStatement("insert into Employee_Invoice values(?,?,?,?,?,?,?,?)");
		System.out.println("OK");
		ps.setInt(1, eid);
		ps.setString(2,ename);
		ps.setDouble(3, salary);
		ps.setDouble(4, ta);
		ps.setDouble(5,da);
		ps.setDouble(6,pf);
		ps.setDouble(7, grosssal);
		ps.setDouble(8,netsal);
		
	int i=ps.executeUpdate();
	System.out.println(i+"Inserted successfully");
	con.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}