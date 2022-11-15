package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@EntityLigoSystem
@Table(name = "salesperson", schema = "sales")
public class Salesperson {
	@Id
	@Column(name = "businessentityid", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "territoryid")
	private Salesterritory territoryid;

	@Column(name = "salesquota")
	private BigDecimal salesquota;

	@Column(name = "bonus", nullable = false)
	private BigDecimal bonus;

	@Column(name = "commissionpct", nullable = false)
	private BigDecimal commissionpct;

	@Column(name = "salesytd", nullable = false)
	private BigDecimal salesytd;

	@Column(name = "saleslastyear", nullable = false)
	private BigDecimal saleslastyear;

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

	public Salesterritory getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(Salesterritory territoryid) {
		this.territoryid = territoryid;
	}

	public BigDecimal getSalesquota() {
		return salesquota;
	}

	public void setSalesquota(BigDecimal salesquota) {
		this.salesquota = salesquota;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getCommissionpct() {
		return commissionpct;
	}

	public void setCommissionpct(BigDecimal commissionpct) {
		this.commissionpct = commissionpct;
	}

	public BigDecimal getSalesytd() {
		return salesytd;
	}

	public void setSalesytd(BigDecimal salesytd) {
		this.salesytd = salesytd;
	}

	public BigDecimal getSaleslastyear() {
		return saleslastyear;
	}

	public void setSaleslastyear(BigDecimal saleslastyear) {
		this.saleslastyear = saleslastyear;
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