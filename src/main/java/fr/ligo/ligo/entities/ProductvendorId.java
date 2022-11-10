package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductvendorId implements Serializable {
	private static final long serialVersionUID = -3297420408919109705L;
	@Column(name = "productid", nullable = false)
	private Integer productid;

	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProductvendorId entity = (ProductvendorId) o;
		return Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.productid, entity.productid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessentityid, productid);
	}

}