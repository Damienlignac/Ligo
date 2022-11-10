package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BusinessentityaddressId implements Serializable {
	private static final long serialVersionUID = -5921594219201952386L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "addressid", nullable = false)
	private Integer addressid;

	@Column(name = "addresstypeid", nullable = false)
	private Integer addresstypeid;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public Integer getAddresstypeid() {
		return addresstypeid;
	}

	public void setAddresstypeid(Integer addresstypeid) {
		this.addresstypeid = addresstypeid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		BusinessentityaddressId entity = (BusinessentityaddressId) o;
		return Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.addresstypeid, entity.addresstypeid) &&
				Objects.equals(this.addressid, entity.addressid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessentityid, addresstypeid, addressid);
	}

}