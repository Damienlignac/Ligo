package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersoncreditcardId implements Serializable {
	private static final long serialVersionUID = -5530951181999848186L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "creditcardid", nullable = false)
	private Integer creditcardid;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Integer getCreditcardid() {
		return creditcardid;
	}

	public void setCreditcardid(Integer creditcardid) {
		this.creditcardid = creditcardid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		PersoncreditcardId entity = (PersoncreditcardId) o;
		return Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.creditcardid, entity.creditcardid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessentityid, creditcardid);
	}

}