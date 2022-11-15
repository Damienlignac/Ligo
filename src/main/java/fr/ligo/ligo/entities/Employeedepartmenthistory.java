package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@EntityLigoSystem
@Table(name = "employeedepartmenthistory", schema = "humanresources")
public class Employeedepartmenthistory {
	@EmbeddedId
	private EmployeedepartmenthistoryId id;

	@MapsId("departmentid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "departmentid", nullable = false)
	private Department departmentid;

	@MapsId("shiftid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "shiftid", nullable = false)
	private Shift shiftid;

	@Column(name = "enddate")
	private LocalDate enddate;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public EmployeedepartmenthistoryId getId() {
		return id;
	}

	public void setId(EmployeedepartmenthistoryId id) {
		this.id = id;
	}

	public Department getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Department departmentid) {
		this.departmentid = departmentid;
	}

	public Shift getShiftid() {
		return shiftid;
	}

	public void setShiftid(Shift shiftid) {
		this.shiftid = shiftid;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}