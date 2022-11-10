package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "workorder", schema = "production")
public class Workorder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workorderid", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false)
	private Product productid;

	@Column(name = "orderqty", nullable = false)
	private Integer orderqty;

	@Column(name = "scrappedqty", nullable = false)
	private Short scrappedqty;

	@Column(name = "startdate", nullable = false)
	private Instant startdate;

	@Column(name = "enddate")
	private Instant enddate;

	@Column(name = "duedate", nullable = false)
	private Instant duedate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scrapreasonid")
	private Scrapreason scrapreasonid;

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

	public Integer getOrderqty() {
		return orderqty;
	}

	public void setOrderqty(Integer orderqty) {
		this.orderqty = orderqty;
	}

	public Short getScrappedqty() {
		return scrappedqty;
	}

	public void setScrappedqty(Short scrappedqty) {
		this.scrappedqty = scrappedqty;
	}

	public Instant getStartdate() {
		return startdate;
	}

	public void setStartdate(Instant startdate) {
		this.startdate = startdate;
	}

	public Instant getEnddate() {
		return enddate;
	}

	public void setEnddate(Instant enddate) {
		this.enddate = enddate;
	}

	public Instant getDuedate() {
		return duedate;
	}

	public void setDuedate(Instant duedate) {
		this.duedate = duedate;
	}

	public Scrapreason getScrapreasonid() {
		return scrapreasonid;
	}

	public void setScrapreasonid(Scrapreason scrapreasonid) {
		this.scrapreasonid = scrapreasonid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}