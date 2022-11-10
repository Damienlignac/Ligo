package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "salesterritoryhistory", schema = "sales")
public class Salesterritoryhistory {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private SalesterritoryhistoryId id;

	@MapsId("businessentityid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false)
	private Salesperson businessentityid;

	@MapsId("territoryid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "territoryid", nullable = false)
	private Salesterritory territoryid;

	@Column(name = "enddate")
	private Instant enddate;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public SalesterritoryhistoryId getId() {
		return id;
	}

	public void setId(SalesterritoryhistoryId id) {
		this.id = id;
	}

	public Salesperson getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Salesperson businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Salesterritory getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(Salesterritory territoryid) {
		this.territoryid = territoryid;
	}

	public Instant getEnddate() {
		return enddate;
	}

	public void setEnddate(Instant enddate) {
		this.enddate = enddate;
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