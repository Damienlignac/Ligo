package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "location", schema = "production")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "locationid", nullable = false)
	private Integer id;

	@Column(name = "costrate", nullable = false)
	private BigDecimal costrate;

	@Column(name = "availability", nullable = false, precision = 8, scale = 2)
	private BigDecimal availability;
	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCostrate() {
		return costrate;
	}

	public void setCostrate(BigDecimal costrate) {
		this.costrate = costrate;
	}

	public BigDecimal getAvailability() {
		return availability;
	}

	public void setAvailability(BigDecimal availability) {
		this.availability = availability;
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