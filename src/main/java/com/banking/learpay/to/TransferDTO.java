package com.banking.learpay.to;
import com.banking.learpay.model.Transfer.Type;

public class TransferDTO {
	
	private Long id;
	private AccountDTO account;
	private Type type;
	
	public TransferDTO() {
		super();
		
	}
	public TransferDTO(Long id, AccountDTO account, Type type) {
		super();
		this.id = id;
		this.account = account;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
