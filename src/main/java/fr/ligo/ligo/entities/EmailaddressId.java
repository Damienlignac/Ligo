package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmailaddressId implements Serializable {
	private static final long serialVersionUID = 8368361129892341195L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "emailaddressid", nullable = false)
	private Integer emailaddressid;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Integer getEmailaddressid() {
		return emailaddressid;
	}

	public void setEmailaddressid(Integer emailaddressid) {
		this.emailaddressid = emailaddressid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		EmailaddressId entity = (EmailaddressId) o;
		return Objects.equals(this.emailaddressid, entity.emailaddressid) &&
				Objects.equals(this.businessentityid, entity.businessentityid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailaddressid, businessentityid);
	}

}