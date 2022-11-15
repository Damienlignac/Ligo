package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "shipmethod", schema = "purchasing")
public class Shipmethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipmethodid", nullable = false)
	private Integer id;

	@Column(name = "shipbase", nullable = false)
	private BigDecimal shipbase;

	@Column(name = "shiprate", nullable = false)
	private BigDecimal shiprate;

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

	public BigDecimal getShipbase() {
		return shipbase;
	}

	public void setShipbase(BigDecimal shipbase) {
		this.shipbase = shipbase;
	}

	public BigDecimal getShiprate() {
		return shiprate;
	}

	public void setShiprate(BigDecimal shiprate) {
		this.shiprate = shiprate;
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