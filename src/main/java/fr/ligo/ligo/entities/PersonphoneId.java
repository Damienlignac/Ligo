package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonphoneId implements Serializable {
	private static final long serialVersionUID = -5281993416758810219L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "phonenumber", nullable = false)
	private Integer phonenumber;

	@Column(name = "phonenumbertypeid", nullable = false)
	private Integer phonenumbertypeid;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Object getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Integer getPhonenumbertypeid() {
		return phonenumbertypeid;
	}

	public void setPhonenumbertypeid(Integer phonenumbertypeid) {
		this.phonenumbertypeid = phonenumbertypeid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		PersonphoneId entity = (PersonphoneId) o;
		return Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.phonenumber, entity.phonenumber) &&
				Objects.equals(this.phonenumbertypeid, entity.phonenumbertypeid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessentityid, phonenumber, phonenumbertypeid);
	}

}