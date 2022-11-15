package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "salespersonquotahistory", schema = "sales")
public class Salespersonquotahistory {
	@EmbeddedId
	private SalespersonquotahistoryId id;

	@MapsId("businessentityid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false)
	private Salesperson businessentityid;

	@Column(name = "salesquota", nullable = false)
	private BigDecimal salesquota;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public SalespersonquotahistoryId getId() {
		return id;
	}

	public void setId(SalespersonquotahistoryId id) {
		this.id = id;
	}

	public Salesperson getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Salesperson businessentityid) {
		this.businessentityid = businessentityid;
	}

	public BigDecimal getSalesquota() {
		return salesquota;
	}

	public void setSalesquota(BigDecimal salesquota) {
		this.salesquota = salesquota;
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