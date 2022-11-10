package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpecialofferproductId implements Serializable {
	private static final long serialVersionUID = 2105934459688876870L;
	@Column(name = "specialofferid", nullable = false)
	private Integer specialofferid;

	@Column(name = "productid", nullable = false)
	private Integer productid;

	public Integer getSpecialofferid() {
		return specialofferid;
	}

	public void setSpecialofferid(Integer specialofferid) {
		this.specialofferid = specialofferid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		SpecialofferproductId entity = (SpecialofferproductId) o;
		return Objects.equals(this.productid, entity.productid) &&
				Objects.equals(this.specialofferid, entity.specialofferid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productid, specialofferid);
	}

}