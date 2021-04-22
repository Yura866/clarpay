package com.banking.learpay.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.learpay.exception.TransferException;
import com.banking.learpay.service.AccountService;
import com.banking.learpay.service.TransferService;
import com.banking.learpay.to.AccountDTO;

@Service(value=InterBankTransfer.BEAN_NAME)
public class InterBankTransfer implements TransferService {
	
	public static final String BEAN_NAME="InterBankTransfer";
	public static final double MAX_TRANSFER_AMOUNT=1000.00;
	public static final double COMMISSION_PERCENTAGE=5;
	public static final float CHANCE_OF_FAILURE_PERCENTAGE=30;
	
	@Autowired
	private AccountService accountService;


	@Override
	public void transfer(AccountDTO accountFrom, AccountDTO accountTo, double amount) throws TransferException{
		
		if (amount > MAX_TRANSFER_AMOUNT) {
			throw new TransferException(String.format("The limit for this type of transfer is %s €, please introduce less amount. ", MAX_TRANSFER_AMOUNT));
		}		
		if (getFailureProbabylity()) {
			throw new TransferException("Something went wrong please try later");
		}
		accountFrom.getAccountLock().writeLock().lock();
		accountTo.getAccountLock().writeLock().lock();
	     try {	    
	    	 putCommission(accountFrom, amount);
	    	 accountService.withdrawAmount(accountFrom.getAccountNumber(), amount);
	    	 accountService.addAmount(accountTo.getAccountNumber(), amount);             
         } finally {
             accountFrom.getAccountLock().writeLock().unlock();
             accountTo.getAccountLock().writeLock().unlock();
         }		
	}
	
	/**
	 * 
	 * @param accountFrom
	 * @param amount
	 */
	private void putCommission(AccountDTO accountFrom, double amount) {
		 double commission=(COMMISSION_PERCENTAGE/100)*amount; 
    	 accountFrom.setBalance(accountFrom.getBalance()-commission);		
	}

	/**
	 * 
	 * @return TRUE if the probabylity more than 30 %
	 */
	private boolean getFailureProbabylity() {
		double probabylity = CHANCE_OF_FAILURE_PERCENTAGE/100;
	    double randomValue = Math.random()*100;
	    return (randomValue <= probabylity) ;
		 
	}
}
