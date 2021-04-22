package com.banking.learpay.service.impl;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.banking.learpay.exception.TransferException;
import com.banking.learpay.model.Account;
import com.banking.learpay.model.Transfer;
import com.banking.learpay.model.Transfer.Type;
import com.banking.learpay.repository.AccountRepository;
import com.banking.learpay.service.TransferService;
import com.banking.learpay.to.AccountDTO;

@Component
public class TransferAgent implements InitializingBean{	

	@Autowired
	private AccountRepository acountService;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Autowired
	private Map<String,TransferService> transferImplMap;

	private Map<Type,TransferService> transferMap = new HashMap<>();

	@Override
	public void afterPropertiesSet() throws Exception {
		this.transferMap.put(Transfer.Type.INTER, transferImplMap.get(InterBankTransfer.BEAN_NAME));
		this.transferMap.put(Transfer.Type.INTRA, transferImplMap.get(IntraBankTransfer.BEAN_NAME));		
	}		

	/**
	 * 
	 * @param accountFrom
	 * @param accountTo
	 * @return
	 */
	public TransferService getTransferService(AccountDTO accountFrom, AccountDTO accountTo) {		
		if (accountFrom.getCustomer().getBank()
				.compareTo(accountTo.getCustomer().getBank()) == 0 ) {			
			return transferMap.get(Transfer.Type.INTRA);
		}else {
			return transferMap.get(Transfer.Type.INTER);
		}		
	}
	
	
	public void transfer(Account accountFrom, Account accountTo, double amount) throws TransferException {				
		transfer(modelMapper.map(accountFrom, AccountDTO.class), modelMapper.map(accountTo, AccountDTO.class), amount);			
	}


	/**
	 * 
	 * @param accountFrom
	 * @param accountTo
	 * @param amount
	 * @return
	 * @throws TransferException 
	 */
	@Transactional
	private void transfer(final AccountDTO accountFrom, final AccountDTO accountTo, final double amount) throws TransferException {			
		try {	
			verifyTransaction( accountFrom,  accountTo,  amount);
			getTransferService(accountFrom, accountTo).transfer(accountFrom, accountTo, amount );
		}catch(Exception e) {			
			throw new TransferException(e.getMessage(), e);			
		}		
	}


	/**
	 * 
	 * @param accountFrom
	 * @param accountTo
	 * @param amount
	 * @throws TransferException 
	 */
	private void verifyTransaction(AccountDTO accountFrom, AccountDTO accountTo, double amount) throws TransferException {
		if (amount <=0) {
			throw new TransferException("The amount should be greater than zero");
		}
		if (amount > accountFrom.getBalance() ) {
			throw new TransferException("The account does not have enough balance");
		}		
		if (!acountService.existsById(accountTo.getId())) {			
			throw new TransferException("The source account does not exist, please provide another one");
		}		
	}
}
