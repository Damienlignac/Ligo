package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductdocumentId implements Serializable {
	private static final long serialVersionUID = -4715238440088564298L;
	@Column(name = "productid", nullable = false)
	private Integer productid;

	@Lob
	@Column(name = "documentnode", nullable = false)
	private String documentnode;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getDocumentnode() {
		return documentnode;
	}

	public void setDocumentnode(String documentnode) {
		this.documentnode = documentnode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProductdocumentId entity = (ProductdocumentId) o;
		return Objects.equals(this.documentnode, entity.documentnode) &&
				Objects.equals(this.productid, entity.productid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentnode, productid);
	}

}