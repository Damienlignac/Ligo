package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class SalespersonquotahistoryId implements Serializable {
	private static final long serialVersionUID = -4518725951882055066L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "quotadate", nullable = false)
	private Instant quotadate;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Instant getQuotadate() {
		return quotadate;
	}

	public void setQuotadate(Instant quotadate) {
		this.quotadate = quotadate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		SalespersonquotahistoryId entity = (SalespersonquotahistoryId) o;
		return Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.quotadate, entity.quotadate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessentityid, quotadate);
	}

}