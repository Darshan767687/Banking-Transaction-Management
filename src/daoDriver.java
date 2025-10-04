import java.util.Scanner;
import com.saven.DTO.Bank_obj;
import com.saven.exception.input_mismatch;

import Services.BankingServices;

import com.saven.Authentication.Authentication;
import com.saven.DAO.BANK_operationimpl;

public class daoDriver {
	static boolean check=false;
	static boolean check1=false;
	static public String acc_number;
	static public  String acc_password;
	static Bank_obj obj;
	static BANK_operationimpl crud;
	static BankingServices serv;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("WELCOME TO SAVEN BANK");
		System.out.println("LOGIN TO THE BANK WITH YOUR CREDENTIALS");
		while(check==false)
		{
			System.out.println("ENTER YOUR  -ACCOUNT NUMBER-  AND -PASSWORD- ");
			acc_number=scan.next();
			acc_password=scan.next();
			check=input_mismatch.Check_mismatch(acc_number,acc_password);
			if(check==true)
			{
				check1=Authentication.Authenticate(Integer.parseInt(acc_number),Integer.parseInt(acc_password));
				if(check1==true)
				{
					crud=new BANK_operationimpl();
					obj= crud.select(Integer.parseInt(acc_number),Integer.parseInt(acc_password));
					System.out.println(obj.getacc_name()+" pls select the service you want");
					break;
				}
				if(check1==false)
				{
					System.out.println("Login failed");
					check=false;

				}
			}
		}
		
		serv=new BankingServices();
		serv.ConsoleMenu(acc_number, acc_password);
	}

}
