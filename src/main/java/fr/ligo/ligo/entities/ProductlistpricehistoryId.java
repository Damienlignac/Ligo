package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class ProductlistpricehistoryId implements Serializable {
	private static final long serialVersionUID = -9171292147559613390L;
	@Column(name = "productid", nullable = false)
	private Integer productid;

	@Column(name = "startdate", nullable = false)
	private Instant startdate;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Instant getStartdate() {
		return startdate;
	}

	public void setStartdate(Instant startdate) {
		this.startdate = startdate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProductlistpricehistoryId entity = (ProductlistpricehistoryId) o;
		return Objects.equals(this.productid, entity.productid) &&
				Objects.equals(this.startdate, entity.startdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productid, startdate);
	}

}