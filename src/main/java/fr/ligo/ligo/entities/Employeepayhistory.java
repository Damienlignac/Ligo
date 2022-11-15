package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "employeepayhistory", schema = "humanresources")
public class Employeepayhistory {
	@EmbeddedId
	private EmployeepayhistoryId id;

	@Column(name = "rate", nullable = false)
	private BigDecimal rate;

	@Column(name = "payfrequency", nullable = false)
	private Short payfrequency;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public EmployeepayhistoryId getId() {
		return id;
	}

	public void setId(EmployeepayhistoryId id) {
		this.id = id;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Short getPayfrequency() {
		return payfrequency;
	}

	public void setPayfrequency(Short payfrequency) {
		this.payfrequency = payfrequency;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}