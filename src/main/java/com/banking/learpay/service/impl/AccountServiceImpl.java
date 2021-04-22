package com.banking.learpay.service.impl;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.learpay.exception.TransferException;
import com.banking.learpay.model.Account;
import com.banking.learpay.repository.AccountRepository;
import com.banking.learpay.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountService;

	@Override
	public void withdrawAmount(String accountNumber, double amount) throws TransferException {		        
		try {
			Account account = accountService.findByAccountNumber(accountNumber).orElseThrow(TransferException::new);	
			account.setBalance(account.getBalance() - amount);			
			accountService.save(account);			
		} catch (Exception e) {				
			throw new TransferException("Error while withdrawing money, please contact to your consultant", e);
		}   		
	}


	@Override
	public void addAmount(String accountNumber, double amount) throws TransferException {
		try {
			Account account = accountService.findByAccountNumber(accountNumber).orElseThrow(TransferException::new);	
			account.setBalance(account.getBalance() + amount);			
			accountService.save(account);			
		} catch (Exception e) {				
			throw new TransferException("Error while withdrawing money, please contact to your consultant", e);
		} 

	}

}
