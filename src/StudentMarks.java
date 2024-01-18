import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentMarks{
public static void main(String[] args) {
	
	try {
		int total=0;int percentage=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter sid, fname,lname,marks of eng,maths and hindi");
		int sid=sc.nextInt();
		String fname=sc.next();
		String lname=sc.next();
		String fullname=fname+" "+lname;
		int eng=sc.nextInt();
		int maths=sc.nextInt();
		int hindi=sc.nextInt();
		System.out.println(total=eng+maths+hindi);
		String result=(eng>=35 && maths>=35 && hindi>=35)?"Pass":"Fail";
		
		percentage=(total*100)/300;
		String grade=((percentage>=80.00)?"A":(percentage>=60 && percentage<80.00)?"B":(percentage>=40.00 && percentage<60.00)?"C":"D");
		
		PreparedStatement ps=con.prepareStatement("insert into StudentMarks values(?,?,?,?,?,?,?,?,?)");
		System.out.println("OK");
		ps.setInt(1, sid);
		ps.setString(2,fullname);
		ps.setInt(3, eng);
		ps.setInt(4, maths);
		ps.setInt(5,hindi);
		ps.setInt(6,total);
		ps.setInt(7, percentage);
		ps.setString(8, null);
		ps.setString(9, result);
		
	int i=ps.executeUpdate();
	System.out.println(i+"Inserted successfully");
	con.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}