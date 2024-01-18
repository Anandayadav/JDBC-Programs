import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableMobile {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create Table Mobile(Model_no number(6),Company_name varchar2(20),Ram_size varchar2(6),Rom_size varchar2(6),OS_name varchar2(10),Processor_Name varchar2(15),IMEI_no number(15),F_cam_size varchar2(6),B_cam_size varchar2(6),Price number(6))");
			System.out.println("table has created");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
