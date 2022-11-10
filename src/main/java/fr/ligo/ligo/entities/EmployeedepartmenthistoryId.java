package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class EmployeedepartmenthistoryId implements Serializable {
	private static final long serialVersionUID = -50616093804765631L;
	@Column(name = "businessentityid", nullable = false)
	private Integer businessentityid;

	@Column(name = "startdate", nullable = false)
	private LocalDate startdate;

	@Column(name = "departmentid", nullable = false)
	private Short departmentid;

	@Column(name = "shiftid", nullable = false)
	private Short shiftid;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public Short getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Short departmentid) {
		this.departmentid = departmentid;
	}

	public Short getShiftid() {
		return shiftid;
	}

	public void setShiftid(Short shiftid) {
		this.shiftid = shiftid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		EmployeedepartmenthistoryId entity = (EmployeedepartmenthistoryId) o;
		return Objects.equals(this.shiftid, entity.shiftid) &&
				Objects.equals(this.businessentityid, entity.businessentityid) &&
				Objects.equals(this.departmentid, entity.departmentid) &&
				Objects.equals(this.startdate, entity.startdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(shiftid, businessentityid, departmentid, startdate);
	}

}