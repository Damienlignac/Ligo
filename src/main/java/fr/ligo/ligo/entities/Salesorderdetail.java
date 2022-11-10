package fr.ligo.ligo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "salesorderdetail", schema = "sales")
public class Salesorderdetail {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private SalesorderdetailId id;

	@MapsId("salesorderid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "salesorderid", nullable = false)
	private Salesorderheader salesorderid;

	@Column(name = "carriertrackingnumber", length = 25)
	private String carriertrackingnumber;

	@Column(name = "orderqty", nullable = false)
	private Short orderqty;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({
			@JoinColumn(name = "specialofferid", referencedColumnName = "specialofferid", nullable = false),
			@JoinColumn(name = "productid", referencedColumnName = "productid", nullable = false)
	})
	private Specialofferproduct specialofferproduct;

	@Column(name = "unitprice", nullable = false)
	private BigDecimal unitprice;

	@Column(name = "unitpricediscount", nullable = false)
	private BigDecimal unitpricediscount;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public SalesorderdetailId getId() {
		return id;
	}

	public void setId(SalesorderdetailId id) {
		this.id = id;
	}

	public Salesorderheader getSalesorderid() {
		return salesorderid;
	}

	public void setSalesorderid(Salesorderheader salesorderid) {
		this.salesorderid = salesorderid;
	}

	public String getCarriertrackingnumber() {
		return carriertrackingnumber;
	}

	public void setCarriertrackingnumber(String carriertrackingnumber) {
		this.carriertrackingnumber = carriertrackingnumber;
	}

	public Short getOrderqty() {
		return orderqty;
	}

	public void setOrderqty(Short orderqty) {
		this.orderqty = orderqty;
	}

	public Specialofferproduct getSpecialofferproduct() {
		return specialofferproduct;
	}

	public void setSpecialofferproduct(Specialofferproduct specialofferproduct) {
		this.specialofferproduct = specialofferproduct;
	}

	public BigDecimal getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}

	public BigDecimal getUnitpricediscount() {
		return unitpricediscount;
	}

	public void setUnitpricediscount(BigDecimal unitpricediscount) {
		this.unitpricediscount = unitpricediscount;
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

}