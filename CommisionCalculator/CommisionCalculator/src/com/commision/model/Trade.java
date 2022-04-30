package com.commision.model;

import java.time.LocalDateTime;

public class Trade {

	private String securityType;
	private String transactionType;
	private long qty;
	private float price;
	private LocalDateTime dateTime = LocalDateTime.now();

	public Trade(String securityType, String transactionType, long qty, float price, LocalDateTime dateTime) {
		super();
		this.securityType = securityType;
		this.transactionType = transactionType;
		this.qty = qty;
		this.price = price;
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Trade [securityType=" + securityType + ", transactionType=" + transactionType + ", qty=" + qty
				+ ", price=" + price + ", now=" + dateTime + "]";
	}

	public String getSecurityType() {
		return securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
