package com.saven.exception;

public class input_mismatch {
	public static boolean Check_mismatch(String s , String l)
	{
		
		int count_s=0;
		int count_l=0;
		for(int i=0;i<s.length();i++)
		{
			if(Character.isDigit(s.charAt(i)))
			{
				count_s++;
			}
		}
		
		for(int j=0;j<l.length();j++)
		{
			if(Character.isDigit(l.charAt(j)))
			{
				count_l++;
			}
		}
		if(count_s==s.length() && count_l==l.length())
		{
			return true;
		}
		else
		{
			System.out.println("enter valid inputs ");
			return false;
		}
	}


}
