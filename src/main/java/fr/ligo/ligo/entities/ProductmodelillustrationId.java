package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductmodelillustrationId implements Serializable {
	private static final long serialVersionUID = 6616303774695056926L;
	@Column(name = "productmodelid", nullable = false)
	private Integer productmodelid;

	@Column(name = "illustrationid", nullable = false)
	private Integer illustrationid;

	public Integer getProductmodelid() {
		return productmodelid;
	}

	public void setProductmodelid(Integer productmodelid) {
		this.productmodelid = productmodelid;
	}

	public Integer getIllustrationid() {
		return illustrationid;
	}

	public void setIllustrationid(Integer illustrationid) {
		this.illustrationid = illustrationid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProductmodelillustrationId entity = (ProductmodelillustrationId) o;
		return Objects.equals(this.productmodelid, entity.productmodelid) &&
				Objects.equals(this.illustrationid, entity.illustrationid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productmodelid, illustrationid);
	}

}