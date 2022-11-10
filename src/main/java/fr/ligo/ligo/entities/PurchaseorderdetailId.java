package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseorderdetailId implements Serializable {
	private static final long serialVersionUID = -3498654905177168291L;
	@Column(name = "purchaseorderid", nullable = false)
	private Integer purchaseorderid;

	@Column(name = "purchaseorderdetailid", nullable = false)
	private Integer purchaseorderdetailid;

	public Integer getPurchaseorderid() {
		return purchaseorderid;
	}

	public void setPurchaseorderid(Integer purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
	}

	public Integer getPurchaseorderdetailid() {
		return purchaseorderdetailid;
	}

	public void setPurchaseorderdetailid(Integer purchaseorderdetailid) {
		this.purchaseorderdetailid = purchaseorderdetailid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		PurchaseorderdetailId entity = (PurchaseorderdetailId) o;
		return Objects.equals(this.purchaseorderdetailid, entity.purchaseorderdetailid) &&
				Objects.equals(this.purchaseorderid, entity.purchaseorderid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchaseorderdetailid, purchaseorderid);
	}

}