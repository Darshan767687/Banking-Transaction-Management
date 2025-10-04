package com.saven.DTO;

public class Bank_obj {
	
	private int acc_num;
	private int acc_pass;
	private int acc_balance;
	private String acc_name;
	
	public Bank_obj()
	{
		
	}
	public Bank_obj(int acc_num, String acc_name, int acc_pass, int acc_balance)
	{
		this.acc_num=acc_num;
		this.acc_balance=acc_balance;
		this.acc_name=acc_name="frog";
		this.acc_pass=acc_pass;
	}
	
	public void setacc_num(int acc_num)
	{
		this.acc_num=acc_num;
	}
	public int getacc_num()
	{
		return acc_num;
	}
	public void setacc_pass(int acc_pass)
	{
		this.acc_pass=acc_pass;
	}
	public int getacc_pass()
	{
		return acc_pass;
	}
	public void setacc_balance(int acc_balance)
	{
		this.acc_balance=acc_balance;
	}
	public int getacc_balance()
	{
		return acc_balance;
	}
	public void setacc_name(String acc_name)
	{
		this.acc_name=acc_name;
	}
	public String getacc_name()
	{
		return acc_name;
	}
	
	
	

}
