package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "productlistpricehistory", schema = "production")
public class Productlistpricehistory {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private ProductlistpricehistoryId id;

	@MapsId("productid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false)
	private Product productid;

	@Column(name = "enddate")
	private Instant enddate;

	@Column(name = "listprice", nullable = false)
	private BigDecimal listprice;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public ProductlistpricehistoryId getId() {
		return id;
	}

	public void setId(ProductlistpricehistoryId id) {
		this.id = id;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public Instant getEnddate() {
		return enddate;
	}

	public void setEnddate(Instant enddate) {
		this.enddate = enddate;
	}

	public BigDecimal getListprice() {
		return listprice;
	}

	public void setListprice(BigDecimal listprice) {
		this.listprice = listprice;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}