package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SalesorderheadersalesreasonId implements Serializable {
	private static final long serialVersionUID = -335549709048380508L;
	@Column(name = "salesorderid", nullable = false)
	private Integer salesorderid;

	@Column(name = "salesreasonid", nullable = false)
	private Integer salesreasonid;

	public Integer getSalesorderid() {
		return salesorderid;
	}

	public void setSalesorderid(Integer salesorderid) {
		this.salesorderid = salesorderid;
	}

	public Integer getSalesreasonid() {
		return salesreasonid;
	}

	public void setSalesreasonid(Integer salesreasonid) {
		this.salesreasonid = salesreasonid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		SalesorderheadersalesreasonId entity = (SalesorderheadersalesreasonId) o;
		return Objects.equals(this.salesreasonid, entity.salesreasonid) &&
				Objects.equals(this.salesorderid, entity.salesorderid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(salesreasonid, salesorderid);
	}

}