package com.banking.learpay.to;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.banking.learpay.model.Customer;

public class BankDTO implements Comparable<BankDTO> {
	private Long id;
	private String name;	
	private List<Customer> customers = new ArrayList<>();
	
	public BankDTO() {
		super();		
	}
	public BankDTO(Long id, String name, List<Customer> customers) {		
		this.id = id;
		this.name = name;
		this.customers = customers;
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
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public int compareTo(BankDTO bank) {		
		return Comparator.comparing(BankDTO::getId)
				.thenComparing(BankDTO::getName)				
				.compare(this, bank);				
	}
}
