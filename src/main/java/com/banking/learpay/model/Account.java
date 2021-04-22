package com.banking.learpay.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "accounts" )
public class Account {

	private static final double RATE = 0.035;  // interest rate of 3.5%

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(name = "account_number")
	private String accountNumber;	
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)	      
	private Customer customer;
	
	@OneToMany(mappedBy="account" , fetch = FetchType.LAZY )	
	private List<Transfer> transfers = new ArrayList<>();
	
	public Account() {}

	public Account(Long id, String accountNumber, double balance, String name, Customer customer, List<Transfer> transfers) {
		super();
		this.id = id;
		this.balance = balance;
		this.name = name;
		this.customer = customer;
		this.transfers = transfers;
		this.accountNumber = accountNumber;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Transfer> getTransfers() {
		return transfers;
	}


	public void setTransfers(List<Transfer> transfers) {
		this.transfers = transfers;
	}


	public static double getRate() {
		return RATE;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}	
	

}
