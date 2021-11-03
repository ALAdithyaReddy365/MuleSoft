import java.sql.*;
import java.util.*;
public class Connectionn {
	public static void main(String[] args){
        try {
	        Class.forName("org.sqlite.JDBC");
	        Connection con = DriverManager.getConnection("jdbc:sqlite:product.db");
	        if(con!=null)
	        {
	        	Statement stmt = con.createStatement();
	        	stmt.executeUpdate("create table movies(name text,actor text,actress text,director text,yearofrelease int)");
	        	stmt.executeUpdate("insert into movies values('Baahubali','Prabhas','Anushka','Rajamouli',2017)");
	        	stmt.executeUpdate("insert into movies values('Saaho','Prabhas','Shraddha','Sujeeth',2019)");
	        	stmt.executeUpdate("insert into movies values('Darling','Prabhas','Kajal','Karunakaran',2010)");
	        	stmt.executeUpdate("insert into movies values('Seetimaar','Gopichand','Tamannaah','Sampath',2021)");
	        	stmt.executeUpdate("insert into movies values('Narappa','Venkatesh','Priyamani','Srikanth',2021)");
	        	stmt.executeUpdate("insert into movies values('Red','Ram','Nivetha','Kishore',2021)");
	        	stmt.executeUpdate("insert into movies values('V','Nani','Aditi','Krishna',2020)");
	        	
	        	PreparedStatement pstmt = con.prepareStatement("select * from movies");
	        	ResultSet rs = pstmt.executeQuery();
	        	System.out.println("Name\tActor\t Actress\t Director\t YearOfRelease");
	        	System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
	        	while(rs.next()) {
	        		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
	        	}
	        	
	        	PreparedStatement ptmt = con.prepareStatement("select name from movies where actor='Prabhas'");
	        	ResultSet rs1 = ptmt.executeQuery();
	        	System.out.println("Movies with the same Actor");
	        	System.out.println("---------------------------");
	        	while(rs1.next()) {
	        		System.out.println(rs1.getString(1));
	        	}
	        	con.close();
	            //System.out.println("connection established successfully");
	        }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
