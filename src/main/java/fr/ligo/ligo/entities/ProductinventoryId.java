package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductinventoryId implements Serializable {
	private static final long serialVersionUID = 6467582699390922575L;
	@Column(name = "productid", nullable = false)
	private Integer productid;

	@Column(name = "locationid", nullable = false)
	private Short locationid;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Short getLocationid() {
		return locationid;
	}

	public void setLocationid(Short locationid) {
		this.locationid = locationid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProductinventoryId entity = (ProductinventoryId) o;
		return Objects.equals(this.productid, entity.productid) &&
				Objects.equals(this.locationid, entity.locationid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productid, locationid);
	}

}