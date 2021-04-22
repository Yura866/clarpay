package com.banking.learpay.to;

public class TransferRequest {
	
	private String destinationAccountNumber;
	private String sourceAccountNumber;
	private double amount;
	
	
	public TransferRequest() {
	}
		
	public TransferRequest(String destinationAccountNumber, String sourceAccountNumber, double amount) {
		super();
		this.destinationAccountNumber = destinationAccountNumber;
		this.sourceAccountNumber = sourceAccountNumber;
		this.amount = amount;
	}
	public String getDestinationAccountNumber() {
		return destinationAccountNumber;
	}
	public void setDestinationAccountNumber(String destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}
	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}
	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
