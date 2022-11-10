package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "specialoffer", schema = "sales")
public class Specialoffer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "specialofferid", nullable = false)
	private Integer id;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "discountpct", nullable = false)
	private BigDecimal discountpct;

	@Column(name = "type", nullable = false, length = 50)
	private String type;

	@Column(name = "category", nullable = false, length = 50)
	private String category;

	@Column(name = "startdate", nullable = false)
	private Instant startdate;

	@Column(name = "enddate", nullable = false)
	private Instant enddate;

	@Column(name = "minqty", nullable = false)
	private Integer minqty;

	@Column(name = "maxqty")
	private Integer maxqty;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDiscountpct() {
		return discountpct;
	}

	public void setDiscountpct(BigDecimal discountpct) {
		this.discountpct = discountpct;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Integer getMinqty() {
		return minqty;
	}

	public void setMinqty(Integer minqty) {
		this.minqty = minqty;
	}

	public Integer getMaxqty() {
		return maxqty;
	}

	public void setMaxqty(Integer maxqty) {
		this.maxqty = maxqty;
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