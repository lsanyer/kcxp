package com.spasvo.kcbp;
import java.sql.*;
import com.spasvo.kcbp.SqlHelper;

public class SqlServerFuc {
	public static void main(String [] args) throws SQLException{
			String SQL = "select fundavl from run..fundasset where custid = '100190'";
			/* ResultSet rs=SqlHelper.executeQuery(SQL);
			 while (rs.next()){  
	             System.out.println(rs.getString("fundavl"));  
	         }   */
			String[][] str = SqlHelper.getDatebases(SQL);
			System.out.println(str[0][0]);
	 }
}
