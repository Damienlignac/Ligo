package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductmodelproductdescriptioncultureId implements Serializable {
	private static final long serialVersionUID = 5680264578859781968L;
	@Column(name = "productmodelid", nullable = false)
	private Integer productmodelid;

	@Column(name = "productdescriptionid", nullable = false)
	private Integer productdescriptionid;

	@Column(name = "cultureid", nullable = false, length = 6)
	private String cultureid;

	public Integer getProductmodelid() {
		return productmodelid;
	}

	public void setProductmodelid(Integer productmodelid) {
		this.productmodelid = productmodelid;
	}

	public Integer getProductdescriptionid() {
		return productdescriptionid;
	}

	public void setProductdescriptionid(Integer productdescriptionid) {
		this.productdescriptionid = productdescriptionid;
	}

	public String getCultureid() {
		return cultureid;
	}

	public void setCultureid(String cultureid) {
		this.cultureid = cultureid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProductmodelproductdescriptioncultureId entity = (ProductmodelproductdescriptioncultureId) o;
		return Objects.equals(this.cultureid, entity.cultureid) &&
				Objects.equals(this.productdescriptionid, entity.productdescriptionid) &&
				Objects.equals(this.productmodelid, entity.productmodelid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cultureid, productdescriptionid, productmodelid);
	}

}