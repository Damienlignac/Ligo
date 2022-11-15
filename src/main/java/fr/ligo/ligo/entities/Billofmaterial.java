package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "billofmaterials", schema = "production")
public class Billofmaterial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "billofmaterialsid", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productassemblyid")
	private Product productassemblyid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "componentid", nullable = false)
	private Product componentid;

	@Column(name = "startdate", nullable = false)
	private Instant startdate;

	@Column(name = "enddate")
	private Instant enddate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "unitmeasurecode", nullable = false)
	private Unitmeasure unitmeasurecode;

	@Column(name = "bomlevel", nullable = false)
	private Short bomlevel;

	@Column(name = "perassemblyqty", nullable = false, precision = 8, scale = 2)
	private BigDecimal perassemblyqty;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductassemblyid() {
		return productassemblyid;
	}

	public void setProductassemblyid(Product productassemblyid) {
		this.productassemblyid = productassemblyid;
	}

	public Product getComponentid() {
		return componentid;
	}

	public void setComponentid(Product componentid) {
		this.componentid = componentid;
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

	public Unitmeasure getUnitmeasurecode() {
		return unitmeasurecode;
	}

	public void setUnitmeasurecode(Unitmeasure unitmeasurecode) {
		this.unitmeasurecode = unitmeasurecode;
	}

	public Short getBomlevel() {
		return bomlevel;
	}

	public void setBomlevel(Short bomlevel) {
		this.bomlevel = bomlevel;
	}

	public BigDecimal getPerassemblyqty() {
		return perassemblyqty;
	}

	public void setPerassemblyqty(BigDecimal perassemblyqty) {
		this.perassemblyqty = perassemblyqty;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}