package com.banking.learpay.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "transfers")
public class Transfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)	
    //@JsonManagedReference    
	private Account account;
	
	@Column(name="type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Type type;
	
	public Transfer() {	}
	
	public Transfer(Account account, Type type) {
		this.account=account;
		this.type = type;
		
	}

	
	public enum Type{	
		INTRA(0,0,0),
		INTER(5,1000,30);	
		private int commissions;
		private int limit;
		private int failure;
		private Type(int commissions, int limit, int failure) {
			this.commissions=commissions;
			this.limit=limit;
			this.failure=failure;
			
		}
		public int getCommissions() {
			return commissions;
		}
		public int getLimit() {
			return limit;
		}
		public int getFailure() {
			return failure;
		}
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
