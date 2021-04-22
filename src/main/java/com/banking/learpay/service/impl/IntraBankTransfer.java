package com.banking.learpay.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.learpay.exception.TransferException;
import com.banking.learpay.service.AccountService;
import com.banking.learpay.service.TransferService;
import com.banking.learpay.to.AccountDTO;

@Service(value=IntraBankTransfer.BEAN_NAME)
public class IntraBankTransfer implements TransferService {
	
	public static final String BEAN_NAME="IntraBankTransfer";

	@Autowired
	AccountService accountService;
	
	@Override
	public void transfer(AccountDTO accountFrom, AccountDTO accountTo, double amount) throws TransferException {
		accountFrom.getAccountLock().writeLock().lock();
		accountTo.getAccountLock().writeLock().lock();
	     try {
	    	 accountService.withdrawAmount(accountFrom.getAccountNumber(), amount);
	    	 accountService.addAmount(accountTo.getAccountNumber(), amount);             
         } finally {
             accountFrom.getAccountLock().writeLock().unlock();
             accountTo.getAccountLock().writeLock().unlock();
         }			
		
	}

}
