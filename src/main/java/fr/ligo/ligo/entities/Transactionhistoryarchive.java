package fr.ligo.ligo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "transactionhistoryarchive", schema = "production")
public class Transactionhistoryarchive {
	@Id
	@Column(name = "transactionid", nullable = false)
	private Integer id;

	@Column(name = "productid", nullable = false)
	private Integer productid;

	@Column(name = "referenceorderid", nullable = false)
	private Integer referenceorderid;

	@Column(name = "referenceorderlineid", nullable = false)
	private Integer referenceorderlineid;

	@Column(name = "transactiondate", nullable = false)
	private Instant transactiondate;

	@Column(name = "transactiontype", nullable = false, length = 1)
	private String transactiontype;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "actualcost", nullable = false)
	private BigDecimal actualcost;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getReferenceorderid() {
		return referenceorderid;
	}

	public void setReferenceorderid(Integer referenceorderid) {
		this.referenceorderid = referenceorderid;
	}

	public Integer getReferenceorderlineid() {
		return referenceorderlineid;
	}

	public void setReferenceorderlineid(Integer referenceorderlineid) {
		this.referenceorderlineid = referenceorderlineid;
	}

	public Instant getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Instant transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getActualcost() {
		return actualcost;
	}

	public void setActualcost(BigDecimal actualcost) {
		this.actualcost = actualcost;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}