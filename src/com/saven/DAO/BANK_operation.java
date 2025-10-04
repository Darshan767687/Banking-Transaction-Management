package com.saven.DAO;

import java.sql.SQLException;

import com.saven.DTO.Bank_obj;


public interface BANK_operation {
	
	boolean update(int acc_num, int amount, int acc_pass) throws SQLException;
	Bank_obj  CheckBalance(int acc_num, int acc_pass )throws SQLException;
	Bank_obj select(int acc_num, int acc_pass) throws SQLException;
	Bank_obj deduct(int acc_num, int acc_pass,int ammount) throws SQLException;
	Bank_obj credit(int acc_num, int acc_pass,int ammount) throws SQLException;
	boolean send(int rec_num,int acc_num, int acc_pass, int ammount) throws SQLException;
}
