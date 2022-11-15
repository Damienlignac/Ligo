package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "productvendor", schema = "purchasing")
public class Productvendor {
	@EmbeddedId
	private ProductvendorId id;

	@MapsId("productid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false, referencedColumnName = "productid")
	private Product productid;

	@MapsId("businessentityid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false)
	private Vendor businessentityid;

	@Column(name = "averageleadtime", nullable = false)
	private Integer averageleadtime;

	@Column(name = "standardprice", nullable = false)
	private BigDecimal standardprice;

	@Column(name = "lastreceiptcost")
	private BigDecimal lastreceiptcost;

	@Column(name = "lastreceiptdate")
	private Instant lastreceiptdate;

	@Column(name = "minorderqty", nullable = false)
	private Integer minorderqty;

	@Column(name = "maxorderqty", nullable = false)
	private Integer maxorderqty;

	@Column(name = "onorderqty")
	private Integer onorderqty;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "unitmeasurecode", nullable = false, referencedColumnName = "unitmeasurecode")
	private Unitmeasure unitmeasurecode;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public ProductvendorId getId() {
		return id;
	}

	public void setId(ProductvendorId id) {
		this.id = id;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public Vendor getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Vendor businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Integer getAverageleadtime() {
		return averageleadtime;
	}

	public void setAverageleadtime(Integer averageleadtime) {
		this.averageleadtime = averageleadtime;
	}

	public BigDecimal getStandardprice() {
		return standardprice;
	}

	public void setStandardprice(BigDecimal standardprice) {
		this.standardprice = standardprice;
	}

	public BigDecimal getLastreceiptcost() {
		return lastreceiptcost;
	}

	public void setLastreceiptcost(BigDecimal lastreceiptcost) {
		this.lastreceiptcost = lastreceiptcost;
	}

	public Instant getLastreceiptdate() {
		return lastreceiptdate;
	}

	public void setLastreceiptdate(Instant lastreceiptdate) {
		this.lastreceiptdate = lastreceiptdate;
	}

	public Integer getMinorderqty() {
		return minorderqty;
	}

	public void setMinorderqty(Integer minorderqty) {
		this.minorderqty = minorderqty;
	}

	public Integer getMaxorderqty() {
		return maxorderqty;
	}

	public void setMaxorderqty(Integer maxorderqty) {
		this.maxorderqty = maxorderqty;
	}

	public Integer getOnorderqty() {
		return onorderqty;
	}

	public void setOnorderqty(Integer onorderqty) {
		this.onorderqty = onorderqty;
	}

	public Unitmeasure getUnitmeasurecode() {
		return unitmeasurecode;
	}

	public void setUnitmeasurecode(Unitmeasure unitmeasurecode) {
		this.unitmeasurecode = unitmeasurecode;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}