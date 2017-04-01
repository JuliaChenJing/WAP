package edu.mum.hw2.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Orders")
public class Order {
	@Id @GeneratedValue
	private int orderId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@ElementCollection
	private Collection<OrderLine> lines = new ArrayList<OrderLine>();
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Collection<OrderLine> getLines() {
		return lines;
	}
	public void setLines(Collection<OrderLine> lines) {
		this.lines = lines;
	}
	

}
