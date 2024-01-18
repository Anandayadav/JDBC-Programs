import java.sql.*;
public class CreateTable {
	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
		Statement stmt=con.createStatement();
		stmt.executeUpdate("create Table student(Sid number(5),Sname varchar2(20),Saddress varchar2(40))");
		System.out.println("table has created");
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}
