package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductproductphotoId implements Serializable {
	private static final long serialVersionUID = 2305321109923101657L;
	@Column(name = "productid", nullable = false)
	private Integer productid;

	@Column(name = "productphotoid", nullable = false)
	private Integer productphotoid;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getProductphotoid() {
		return productphotoid;
	}

	public void setProductphotoid(Integer productphotoid) {
		this.productphotoid = productphotoid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProductproductphotoId entity = (ProductproductphotoId) o;
		return Objects.equals(this.productid, entity.productid) &&
				Objects.equals(this.productphotoid, entity.productphotoid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productid, productphotoid);
	}

}