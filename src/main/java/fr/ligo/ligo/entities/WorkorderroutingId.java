package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WorkorderroutingId implements Serializable {
	private static final long serialVersionUID = 5653057092908574551L;
	@Column(name = "workorderid", nullable = false)
	private Integer workorderid;

	@Column(name = "productid", nullable = false)
	private Integer productid;

	@Column(name = "operationsequence", nullable = false)
	private Short operationsequence;

	public Integer getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(Integer workorderid) {
		this.workorderid = workorderid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Short getOperationsequence() {
		return operationsequence;
	}

	public void setOperationsequence(Short operationsequence) {
		this.operationsequence = operationsequence;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		WorkorderroutingId entity = (WorkorderroutingId) o;
		return Objects.equals(this.workorderid, entity.workorderid) &&
				Objects.equals(this.productid, entity.productid) &&
				Objects.equals(this.operationsequence, entity.operationsequence);
	}

	@Override
	public int hashCode() {
		return Objects.hash(workorderid, productid, operationsequence);
	}

}