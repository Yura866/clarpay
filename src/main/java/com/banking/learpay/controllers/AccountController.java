package com.banking.learpay.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banking.learpay.exception.TransferException;
import com.banking.learpay.model.Account;
import com.banking.learpay.repository.AccountRepository;
import com.banking.learpay.service.impl.TransferAgent;
import com.banking.learpay.to.TransferRequest;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

	@Autowired
	private AccountRepository accountRepo;	
	
	@Autowired	
	private TransferAgent transferAgent;	

	
	@PostMapping(value = "/transfer")
	public ResponseEntity<String> transfer(@RequestBody TransferRequest transfer) throws TransferException {
		
		Account accountFrom = accountRepo.findByAccountNumber(transfer.getSourceAccountNumber()).orElseThrow(() ->
		new TransferException(String.format("The account %s doesn't exist", transfer.getSourceAccountNumber())));
		
		Account accountTo = accountRepo.findByAccountNumber(transfer.getDestinationAccountNumber()).orElseThrow(() ->
		new TransferException(String.format("The account %s doesn't exist", transfer.getDestinationAccountNumber())));
		
		transferAgent.transfer(accountFrom, accountTo, transfer.getAmount());
	
		return new ResponseEntity <>("The transaction was successful !",HttpStatus.OK);
	}

}
