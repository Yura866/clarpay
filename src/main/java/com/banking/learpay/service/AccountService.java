package com.banking.learpay.service;

import com.banking.learpay.exception.TransferException;

public interface AccountService {
	public void withdrawAmount(String  accountNumber, double amount) throws TransferException;
	public void addAmount(String accountNumber,double amount) throws TransferException;;
}
