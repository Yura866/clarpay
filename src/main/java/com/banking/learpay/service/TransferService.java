package com.banking.learpay.service;
import com.banking.learpay.exception.TransferException;
import com.banking.learpay.to.AccountDTO;

public interface TransferService {
	public void transfer (AccountDTO accountFrom, AccountDTO accountTo, double amount) throws TransferException;	
}
