package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "transactionhistory", schema = "production")
public class Transactionhistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionid", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false)
	private Product productid;

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

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
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