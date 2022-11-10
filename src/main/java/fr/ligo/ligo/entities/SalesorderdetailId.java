package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SalesorderdetailId implements Serializable {
	private static final long serialVersionUID = 5861613915333382126L;
	@Column(name = "salesorderid", nullable = false)
	private Integer salesorderid;

	@Column(name = "salesorderdetailid", nullable = false)
	private Integer salesorderdetailid;

	public Integer getSalesorderid() {
		return salesorderid;
	}

	public void setSalesorderid(Integer salesorderid) {
		this.salesorderid = salesorderid;
	}

	public Integer getSalesorderdetailid() {
		return salesorderdetailid;
	}

	public void setSalesorderdetailid(Integer salesorderdetailid) {
		this.salesorderdetailid = salesorderdetailid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		SalesorderdetailId entity = (SalesorderdetailId) o;
		return Objects.equals(this.salesorderdetailid, entity.salesorderdetailid) &&
				Objects.equals(this.salesorderid, entity.salesorderid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(salesorderdetailid, salesorderid);
	}

}