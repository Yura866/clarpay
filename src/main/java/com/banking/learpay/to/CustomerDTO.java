package com.banking.learpay.to;
import java.util.ArrayList;
import java.util.List;
import com.banking.learpay.model.Account;

public class CustomerDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private BankDTO bank;	
	private List<Account> accounts = new ArrayList<>();

	public CustomerDTO() {
		super();
	}
	public CustomerDTO(Long id, String firstName, String lastName, BankDTO bank, List<Account> accounts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bank = bank;
		this.accounts = accounts;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public BankDTO getBank() {
		return bank;
	}
	public void setBank(BankDTO bank) {
		this.bank = bank;
	}	

}
