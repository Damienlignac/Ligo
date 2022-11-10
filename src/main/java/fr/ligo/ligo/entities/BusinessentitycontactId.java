package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BusinessentitycontactId implements Serializable {
	private static final long serialVersionUID = -9143585084791109958L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "personid", nullable = false)
	private Integer personid;

	@Column(name = "contacttypeid", nullable = false)
	private Integer contacttypeid;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Integer getPersonid() {
		return personid;
	}

	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	public Integer getContacttypeid() {
		return contacttypeid;
	}

	public void setContacttypeid(Integer contacttypeid) {
		this.contacttypeid = contacttypeid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		BusinessentitycontactId entity = (BusinessentitycontactId) o;
		return Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.contacttypeid, entity.contacttypeid) &&
				Objects.equals(this.personid, entity.personid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessentityid, contacttypeid, personid);
	}

}