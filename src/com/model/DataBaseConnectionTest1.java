package com.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnectionTest1 {
public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
	int rowno=0;
	int colno=0;
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from cjcemp");
	
	while(rs.next())
	{
		String empnm=rs.getString("emp-name");
		System.out.println(empnm);
		double empsl=rs.getDouble("emp-salary");
		System.out.println(empsl);
		WriteExcelData wed=new WriteExcelData();
		wed.writeExcel("F:\\JAVA.TestNG-workspace\\Database connectivity\\dbConnct.xlsx", "Sheet1", rowno++, colno, empnm, empsl);
	}
}
}
