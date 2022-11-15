package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "salestaxrate", schema = "sales")
public class Salestaxrate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salestaxrateid", nullable = false)
	private Integer id;

	@Column(name = "stateprovinceid", nullable = false)
	private Integer stateprovinceid;

	@Column(name = "taxtype", nullable = false)
	private Short taxtype;

	@Column(name = "taxrate", nullable = false)
	private BigDecimal taxrate;

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

	public Integer getStateprovinceid() {
		return stateprovinceid;
	}

	public void setStateprovinceid(Integer stateprovinceid) {
		this.stateprovinceid = stateprovinceid;
	}

	public Short getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(Short taxtype) {
		this.taxtype = taxtype;
	}

	public BigDecimal getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(BigDecimal taxrate) {
		this.taxrate = taxrate;
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

    @Column(name = "name", nullable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}