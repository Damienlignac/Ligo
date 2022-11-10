package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class SalesterritoryhistoryId implements Serializable {
	private static final long serialVersionUID = 8284353051030345870L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "startdate", nullable = false)
	private Instant startdate;

	@Column(name = "territoryid", nullable = false)
	private Integer territoryid;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Instant getStartdate() {
		return startdate;
	}

	public void setStartdate(Instant startdate) {
		this.startdate = startdate;
	}

	public Integer getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(Integer territoryid) {
		this.territoryid = territoryid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		SalesterritoryhistoryId entity = (SalesterritoryhistoryId) o;
		return Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.territoryid, entity.territoryid) &&
				Objects.equals(this.startdate, entity.startdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessentityid, territoryid, startdate);
	}

}