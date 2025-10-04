package com.saven.Authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.saven.connection.Connection_factory;

public class Authentication {
	static Connection con=null;
	static PreparedStatement stm=null;
	static ResultSet res=null;
	static boolean result =false;
	public static boolean Authenticate(int acc_num, int acc_pass)
	{
		try {
			con=Connection_factory.requestConnection();
			con.setAutoCommit(false);
			con.setSavepoint();
			String query="select * from accounts where acc_num= ? and acc_pass= ? ";
			stm=con.prepareStatement(query);
			stm.setInt(1, acc_num);
			stm.setInt(2, acc_pass);
			res=stm.executeQuery();
			if(res.next())
			{
				con.commit();
				result=true;
				con.close();
			}
			else
			{
				result = false;
				con.close();
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}

}
