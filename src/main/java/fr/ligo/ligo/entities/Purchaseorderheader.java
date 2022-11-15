package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "purchaseorderheader", schema = "purchasing")
public class Purchaseorderheader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchaseorderid", nullable = false)
	private Integer id;

	@Column(name = "revisionnumber", nullable = false)
	private Short revisionnumber;

	@Column(name = "status", nullable = false)
	private Short status;

	@Column(name = "employeeid", nullable = false)
	private Integer employeeid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "vendorid", nullable = false)
	private Vendor vendorid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "shipmethodid", nullable = false)
	private Shipmethod shipmethodid;

	@Column(name = "orderdate", nullable = false)
	private Instant orderdate;

	@Column(name = "shipdate")
	private Instant shipdate;

	@Column(name = "subtotal", nullable = false)
	private BigDecimal subtotal;

	@Column(name = "taxamt", nullable = false)
	private BigDecimal taxamt;

	@Column(name = "freight", nullable = false)
	private BigDecimal freight;

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

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Vendor getVendorid() {
		return vendorid;
	}

	public void setVendorid(Vendor vendorid) {
		this.vendorid = vendorid;
	}

	public Shipmethod getShipmethodid() {
		return shipmethodid;
	}

	public void setShipmethodid(Shipmethod shipmethodid) {
		this.shipmethodid = shipmethodid;
	}

	public Instant getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Instant orderdate) {
		this.orderdate = orderdate;
	}

	public Instant getShipdate() {
		return shipdate;
	}

	public void setShipdate(Instant shipdate) {
		this.shipdate = shipdate;
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

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}