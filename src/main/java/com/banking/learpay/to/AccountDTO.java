package com.banking.learpay.to;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.banking.learpay.model.Account;

public class AccountDTO implements Comparable<AccountDTO> {
	
	
	private Long id;
	private double balance;
	private String name;	
	private CustomerDTO customer;	
	private String accountNumber;	
	
	private ReadWriteLock accountLock = new ReentrantReadWriteLock();
	
	private List<TransferDTO> transfers = new ArrayList<>();
	
	public AccountDTO() {}
	
	public AccountDTO(String accountNumber, CustomerDTO accountHolder) {
		this.balance = 0.00;
	    this.setAccountNumber(accountNumber);
	    this.setCustomer(accountHolder);
		this.accountLock = new ReentrantReadWriteLock();
	}
	
	public AccountDTO(Long id, double balance, String name, CustomerDTO accountHolder, String accountNumber,
			List<TransferDTO> transfers) {
		super();
		this.id = id;
		this.balance = balance;
		this.name = name;
		this.setCustomer(accountHolder);
		this.setAccountNumber(accountNumber);
		this.transfers = transfers;
		this.accountLock = new ReentrantReadWriteLock();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}	


	public ReadWriteLock getAccountLock() {
		return accountLock;
	}

	public List<TransferDTO> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<TransferDTO> transfers) {
		this.transfers = transfers;
	}
	
	@Override
	public int compareTo(AccountDTO account) {		
		return Comparator.comparing(AccountDTO::getName)							
				.thenComparing(AccountDTO::getAccountNumber)
				.compare(this, account);				
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
