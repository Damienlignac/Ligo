package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "salesorderheader", schema = "sales")
public class Salesorderheader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salesorderid", nullable = false)
	private Integer id;

	@Column(name = "revisionnumber", nullable = false)
	private Short revisionnumber;

	@Column(name = "orderdate", nullable = false)
	private Instant orderdate;

	@Column(name = "duedate", nullable = false)
	private Instant duedate;

	@Column(name = "shipdate")
	private Instant shipdate;

	@Column(name = "status", nullable = false)
	private Short status;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customerid", nullable = false)
	private Customer customerid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salespersonid")
	private Salesperson salespersonid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "territoryid")
	private Salesterritory territoryid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "billtoaddressid", nullable = false, referencedColumnName = "addressid")
	private Address billtoaddressid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "shiptoaddressid", nullable = false, referencedColumnName = "addressid")
	private Address shiptoaddressid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "shipmethodid", nullable = false, referencedColumnName = "shipmethodid")
	private Shipmethod shipmethodid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creditcardid")
	private Creditcard creditcardid;

	@Column(name = "creditcardapprovalcode", length = 15)
	private String creditcardapprovalcode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currencyrateid")
	private Currencyrate currencyrateid;

	@Column(name = "subtotal", nullable = false)
	private BigDecimal subtotal;

	@Column(name = "taxamt", nullable = false)
	private BigDecimal taxamt;
	@Column(name = "comment", length = 128)
	private String comment;

	@Column(name = "freight", nullable = false)
	private BigDecimal freight;
	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "totaldue")
	private BigDecimal totaldue;
	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getRevisionnumber() {
		return revisionnumber;
	}

	public void setRevisionnumber(Short revisionnumber) {
		this.revisionnumber = revisionnumber;
	}

	public Instant getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Instant orderdate) {
		this.orderdate = orderdate;
	}

	public Instant getDuedate() {
		return duedate;
	}

	public void setDuedate(Instant duedate) {
		this.duedate = duedate;
	}

	public Instant getShipdate() {
		return shipdate;
	}

	public void setShipdate(Instant shipdate) {
		this.shipdate = shipdate;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Customer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Customer customerid) {
		this.customerid = customerid;
	}

	public Salesperson getSalespersonid() {
		return salespersonid;
	}

	public void setSalespersonid(Salesperson salespersonid) {
		this.salespersonid = salespersonid;
	}

	public Salesterritory getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(Salesterritory territoryid) {
		this.territoryid = territoryid;
	}

	public Address getBilltoaddressid() {
		return billtoaddressid;
	}

	public void setBilltoaddressid(Address billtoaddressid) {
		this.billtoaddressid = billtoaddressid;
	}

	public Address getShiptoaddressid() {
		return shiptoaddressid;
	}

	public void setShiptoaddressid(Address shiptoaddressid) {
		this.shiptoaddressid = shiptoaddressid;
	}

	public Shipmethod getShipmethodid() {
		return shipmethodid;
	}

	public void setShipmethodid(Shipmethod shipmethodid) {
		this.shipmethodid = shipmethodid;
	}

	public Creditcard getCreditcardid() {
		return creditcardid;
	}

	public void setCreditcardid(Creditcard creditcardid) {
		this.creditcardid = creditcardid;
	}

	public String getCreditcardapprovalcode() {
		return creditcardapprovalcode;
	}

	public void setCreditcardapprovalcode(String creditcardapprovalcode) {
		this.creditcardapprovalcode = creditcardapprovalcode;
	}

	public Currencyrate getCurrencyrateid() {
		return currencyrateid;
	}

	public void setCurrencyrateid(Currencyrate currencyrateid) {
		this.currencyrateid = currencyrateid;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTaxamt() {
		return taxamt;
	}

	public void setTaxamt(BigDecimal taxamt) {
		this.taxamt = taxamt;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public BigDecimal getTotaldue() {
		return totaldue;
	}

	public void setTotaldue(BigDecimal totaldue) {
		this.totaldue = totaldue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UUID getRowguid() {
		return rowguid;
	}

	public void setRowguid(UUID rowguid) {
		this.rowguid = rowguid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

/*
    TODO [JPA Buddy] create field to map the 'onlineorderflag' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "onlineorderflag", columnDefinition = "public.Flag(1) not null")
    private Object onlineorderflag;
*/
/*
    TODO [JPA Buddy] create field to map the 'purchaseordernumber' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "purchaseordernumber", columnDefinition = "public.OrderNumber(29)")
    private Object purchaseordernumber;
*/
/*
    TODO [JPA Buddy] create field to map the 'accountnumber' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "accountnumber", columnDefinition = "public.AccountNumber(19)")
    private Object accountnumber;
*/
}