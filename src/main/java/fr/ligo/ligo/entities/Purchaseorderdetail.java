package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "purchaseorderdetail", schema = "purchasing")
public class Purchaseorderdetail {
	@EmbeddedId
	private PurchaseorderdetailId id;

	@MapsId("purchaseorderid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "purchaseorderid", nullable = false)
	private Purchaseorderheader purchaseorderid;

	@Column(name = "duedate", nullable = false)
	private Instant duedate;

	@Column(name = "orderqty", nullable = false)
	private Short orderqty;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false, referencedColumnName = "productid")
	private Product productid;

	@Column(name = "unitprice", nullable = false)
	private BigDecimal unitprice;

	@Column(name = "receivedqty", nullable = false, precision = 8, scale = 2)
	private BigDecimal receivedqty;

	@Column(name = "rejectedqty", nullable = false, precision = 8, scale = 2)
	private BigDecimal rejectedqty;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public PurchaseorderdetailId getId() {
		return id;
	}

	public void setId(PurchaseorderdetailId id) {
		this.id = id;
	}

	public Purchaseorderheader getPurchaseorderid() {
		return purchaseorderid;
	}

	public void setPurchaseorderid(Purchaseorderheader purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
	}

	public Instant getDuedate() {
		return duedate;
	}

	public void setDuedate(Instant duedate) {
		this.duedate = duedate;
	}

	public Short getOrderqty() {
		return orderqty;
	}

	public void setOrderqty(Short orderqty) {
		this.orderqty = orderqty;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public BigDecimal getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}

	public BigDecimal getReceivedqty() {
		return receivedqty;
	}

	public void setReceivedqty(BigDecimal receivedqty) {
		this.receivedqty = receivedqty;
	}

	public BigDecimal getRejectedqty() {
		return rejectedqty;
	}

	public void setRejectedqty(BigDecimal rejectedqty) {
		this.rejectedqty = rejectedqty;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}