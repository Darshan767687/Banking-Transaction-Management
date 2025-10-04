package Services;

import java.sql.SQLException;
import java.util.Scanner;

import com.saven.DAO.BANK_operationimpl;
import com.saven.DTO.Bank_obj;

public class BankingServices
{
	BANK_operationimpl boi;
	Bank_obj obl;
	boolean bas=false;
	public void ConsoleMenu(String acc_num,String acc_pass)
	{
		boi=new BANK_operationimpl();
		Scanner scan = new Scanner(System.in);
		int input=0;
		while(input!=5)
		{
		System.out.println("1 : WITHDRAW");
		System.out.println("2 : CHECK BALANCE");
		System.out.println("3 : ADD BALANCE");
		System.out.println("4 : SEND MONEY");
		System.out.println("5 : STOP SERVICES");
		input=scan.nextInt();
		if(input==1)
		{
			System.out.println("enter the amount");
			int amount=scan.nextInt();
			obl=boi.deduct(Integer.parseInt(acc_num),Integer.parseInt(acc_pass),amount);
			System.out.println("your current balance is - "+obl.getacc_balance());
		}
		else if(input==2)
		{
			
			try {
				obl=boi.CheckBalance(Integer.parseInt(acc_num), Integer.parseInt(acc_pass));
				
				System.out.println("your current balance is"+obl.getacc_balance());
				
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}

		}
		else if(input==3)
		{
			System.out.println("enter the amount to be added");
			int amount=scan.nextInt();
			obl=boi.credit(Integer.parseInt(acc_num), Integer.parseInt(acc_pass),amount );
			System.out.println(obl.getacc_balance());

		}
		else if(input==4)
		{
			System.out.println("enter the reciever account number");
			int rec_num=scan.nextInt();
			System.out.println("enter the amount");
			int amt=scan.nextInt();
			try {
				
				obl=boi.CheckBalance(Integer.parseInt(acc_num), Integer.parseInt(acc_pass));
				
				if(amt<=obl.getacc_balance())
				{
					boolean sys=boi.send(rec_num, Integer.parseInt(acc_num), Integer.parseInt(acc_pass), amt);
					if(sys)
					{
						System.out.println("Amount sent");
					}
					else
					{
						System.out.println("transaction terminated");
					}
				}
				else
				{
					System.out.println("insufficience funds");
				}
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	}
}
