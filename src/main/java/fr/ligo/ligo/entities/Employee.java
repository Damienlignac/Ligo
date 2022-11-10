package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employee", schema = "humanresources")
public class Employee {
	@Id
	@Column(name = "businessentityid", nullable = false)
	private Integer id;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false, referencedColumnName = "businessentityid")
	private Person person;

	@Column(name = "nationalidnumber", nullable = false, length = 15)
	private String nationalidnumber;

	@Column(name = "loginid", nullable = false, length = 256)
	private String loginid;

	@Column(name = "jobtitle", nullable = false, length = 50)
	private String jobtitle;

	@Column(name = "birthdate", nullable = false)
	private LocalDate birthdate;

	@Column(name = "maritalstatus", nullable = false, length = 1)
	private String maritalstatus;

	@Column(name = "gender", nullable = false, length = 1)
	private String gender;

	@Column(name = "hiredate", nullable = false)
	private LocalDate hiredate;

	@Column(name = "vacationhours", nullable = false)
	private Short vacationhours;

	@Column(name = "sickleavehours", nullable = false)
	private Short sickleavehours;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;
	@Lob
	@Column(name = "organizationnode")
	private String organizationnode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getNationalidnumber() {
		return nationalidnumber;
	}

	public void setNationalidnumber(String nationalidnumber) {
		this.nationalidnumber = nationalidnumber;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getHiredate() {
		return hiredate;
	}

	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}

	public Short getVacationhours() {
		return vacationhours;
	}

	public void setVacationhours(Short vacationhours) {
		this.vacationhours = vacationhours;
	}

	public Short getSickleavehours() {
		return sickleavehours;
	}

	public void setSickleavehours(Short sickleavehours) {
		this.sickleavehours = sickleavehours;
	}

	public UUID getRowguid() {
		return rowguid;
	}

	public void setRowguid(UUID rowguid) {
		this.rowguid = rowguid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getOrganizationnode() {
		return organizationnode;
	}

	public void setOrganizationnode(String organizationnode) {
		this.organizationnode = organizationnode;
	}

/*
    TODO [JPA Buddy] create field to map the 'salariedflag' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "salariedflag", columnDefinition = "public.Flag(1) not null")
    private Object salariedflag;
*/
/*
    TODO [JPA Buddy] create field to map the 'currentflag' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "currentflag", columnDefinition = "public.Flag(1) not null")
    private Object currentflag;
*/
}