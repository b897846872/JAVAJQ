package com.demo.grabRedPacket.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author qi
 */
public class RedPacket implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long userId;
	private Double amount;
	private Timestamp senfDate;
	private Integer total;
	private Double unitAmount;
	private Integer stock;
	private Integer version;
	private String note;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Timestamp getSenfDate() {
		return senfDate;
	}
	public void setSenfDate(Timestamp senfDate) {
		this.senfDate = senfDate;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Double getUnitAmount() {
		return unitAmount;
	}
	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
