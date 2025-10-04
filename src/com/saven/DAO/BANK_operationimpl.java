package com.saven.DAO;
import com.saven.DTO.Bank_obj;
import com.saven.connection.Connection_factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class BANK_operationimpl implements BANK_operation{
	
	public boolean send(int rec_num,int acc_num,int acc_pass, int ammount)
	{
		Connection con=null;
		PreparedStatement stm7;
		PreparedStatement stm8;
		Savepoint sp;
		boolean confirm=false;
		int retur;
		int ter;
		Bank_obj obs=null;
		
		try {
			con=Connection_factory.requestConnection();
			con.setAutoCommit(false);
			sp=con.setSavepoint();
			String query7="update  accounts set acc_balance=acc_balance- ? where acc_num= ? and acc_pass= ? ";
			String query8="update  accounts set acc_balance=acc_balance+ ? where acc_num= ? ";
			stm7=con.prepareStatement(query7);
			stm8=con.prepareStatement(query8);
			stm7.setInt(1,ammount);
			stm7.setInt(2, acc_num);
			stm7.setInt(3,acc_pass);
			stm8.setInt(1,ammount);
			stm8.setInt(2,rec_num);
			retur=stm7.executeUpdate();
			ter=stm8.executeUpdate();
			if(retur>=1 && ter>=1)
			{
				con.commit();
				return true;
			
			}
			else
			{
				con.rollback(sp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	
	public Bank_obj credit(int acc_num, int acc_pass,int ammount)
	{
		Connection con =null;
		PreparedStatement stm5;
		PreparedStatement stm6;
		Savepoint sp;
		int retu;
		Bank_obj om=null;
		
		try {
			con=Connection_factory.requestConnection();
			con.setAutoCommit(false);
			sp=con.setSavepoint();
			String query5="update accounts set acc_balance=acc_balance + ? where acc_num= ? and acc_pass= ?";
			String query6="select acc_balance from accounts where acc_num= ? and acc_pass = ?";
			stm5=con.prepareStatement(query5);
			stm5.setInt(1, ammount);
			stm5.setInt(2, acc_num);
			stm5.setInt(3, acc_pass);
			stm6=con.prepareStatement(query6);
			stm6.setInt(1,acc_num);
			stm6.setInt(2,acc_pass);
			retu=stm5.executeUpdate();
			if(retu>=1)
			{
				con.commit();
				ResultSet resss=stm6.executeQuery();
				if(resss.next())
				{
					int bal=resss.getInt(1);
					om=new Bank_obj();
					om.setacc_balance(bal);
				}
				con.close();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return om;
		
	}
	
	public Bank_obj deduct(int acc_num, int acc_pass, int ammount)
	{
		Connection con=null;
		Savepoint sp;
		PreparedStatement stm3;
		PreparedStatement stm4;
		int ress;
		boolean retur=false;
		Bank_obj bob=null;
		
		try {
			con=Connection_factory.requestConnection();
			con.setAutoCommit(false);
			sp=con.setSavepoint();
			String Qery3="update accounts set acc_balance= acc_balance- ? where acc_num= ? and acc_pass= ? ";
			String Qery4="select acc_balance from accounts where acc_num= ? and acc_pass= ? ";
			stm4=con.prepareStatement(Qery4);
			stm4.setInt(1, acc_num);
			stm4.setInt(2, acc_pass);
			stm3=con.prepareStatement(Qery3);
			stm3.setInt(1, ammount);
			stm3.setInt(2,acc_num);
			stm3.setInt(3,acc_pass);
			ress=stm3.executeUpdate();
			
			if(ress>=1)
			{
				con.commit();
				ResultSet result=stm4.executeQuery();
				if(result.next())
				{
					int balance=result.getInt(1);
					bob=new Bank_obj();
					bob.setacc_balance(balance);
					retur=true;
				}
				
			}
			else
			{
				con.rollback();
			}
			
			
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return bob;
	}

	public boolean update(int acc_num, int amount, int acc_pass)throws SQLException
	{
		Savepoint sp=null;
		Connection con=null;
		boolean result=false;
		try {
			con=Connection_factory.requestConnection();
			con.setAutoCommit(false);
			sp=con.setSavepoint();
			String Query="update accounts set acc_balance= acc_balance + ? where acc_num= ? and acc_pass = ?";
			PreparedStatement stm1=con.prepareStatement(Query);
			stm1.setInt(1, amount);
			stm1.setInt(2, acc_num);
			stm1.setInt(3, acc_pass);
			int b=stm1.executeUpdate(Query);
			if(b==1)
			{
				con.commit();
				result = true;
				
			}
			else
			{
				con.rollback(sp);
				result = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			con.rollback();

		}
		return result;

	}

	public Bank_obj CheckBalance(int acc_num, int acc_pass) throws SQLException{
		Connection con=null;
		Savepoint sp=null;
		int balance=0;
		PreparedStatement stm2=null;
		Bank_obj ba=null;

		try {
			con=Connection_factory.requestConnection();
			con.setAutoCommit(false);
			sp=con.setSavepoint();
			String Query2="select acc_balance from accounts where acc_num= ? and acc_pass= ? ";
			stm2=con.prepareStatement(Query2);
			stm2.setInt(1, acc_num);
			stm2.setInt(2, acc_pass);
			ResultSet res=stm2.executeQuery();
			if(res.next())
			{
				balance=res.getInt(1);
				con.commit();
				ba=new Bank_obj();
				ba.setacc_balance(balance);
			}
			else
			{
				con.rollback(sp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			con.rollback();
		}

		return ba ;
	}
	public Bank_obj select(int acc_num, int acc_pass)
	{
		Connection con=null;
		PreparedStatement smt2=null;
		ResultSet res=null;
		Bank_obj boj=null;
		Savepoint sp=null;
		
		try {
			con=Connection_factory.requestConnection();
			con.setAutoCommit(false);
			sp=con.setSavepoint();
			String query2="select acc_name from accounts where acc_num= ? and acc_pass= ? ";
			smt2=con.prepareStatement(query2);
			smt2.setInt(1, acc_num);
			smt2.setInt(2, acc_pass);
			res=smt2.executeQuery();
			if(res.next())
			{
				con.commit();
				boj=new Bank_obj();
				boj.setacc_name(res.getString(1));
			}
			else
			{
					con.rollback(sp);
					con.close();
			}
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return boj;
	}




}
