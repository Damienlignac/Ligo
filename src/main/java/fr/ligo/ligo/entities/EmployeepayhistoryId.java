package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class EmployeepayhistoryId implements Serializable {
	private static final long serialVersionUID = 7695544676316054141L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "ratechangedate", nullable = false)
	private Instant ratechangedate;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Instant getRatechangedate() {
		return ratechangedate;
	}

	public void setRatechangedate(Instant ratechangedate) {
		this.ratechangedate = ratechangedate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		EmployeepayhistoryId entity = (EmployeepayhistoryId) o;
		return Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.ratechangedate, entity.ratechangedate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessentityid, ratechangedate);
	}

}