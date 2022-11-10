package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "person", schema = "person")
public class Person {
	@Id
	@Column(name = "businessentityid", nullable = false)
	private Integer id;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false)
	private Businessentity businessentity;

	@Column(name = "persontype", nullable = false, length = 2)
	private String persontype;

	@Column(name = "title", length = 8)
	private String title;
	@Column(name = "suffix", length = 10)
	private String suffix;

	@Column(name = "emailpromotion", nullable = false)
	private Integer emailpromotion;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Businessentity getBusinessentity() {
		return businessentity;
	}

	public void setBusinessentity(Businessentity businessentity) {
		this.businessentity = businessentity;
	}

	public String getPersontype() {
		return persontype;
	}

	public void setPersontype(String persontype) {
		this.persontype = persontype;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getEmailpromotion() {
		return emailpromotion;
	}

	public void setEmailpromotion(Integer emailpromotion) {
		this.emailpromotion = emailpromotion;
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

/*
    TODO [JPA Buddy] create field to map the 'namestyle' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "namestyle", columnDefinition = "public.NameStyle(1) not null")
    private Object namestyle;
*/
/*
    TODO [JPA Buddy] create field to map the 'firstname' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "firstname", columnDefinition = "public.Name(54) not null")
    private Object firstname;
*/
/*
    TODO [JPA Buddy] create field to map the 'middlename' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "middlename", columnDefinition = "public.Name(54)")
    private Object middlename;
*/
/*
    TODO [JPA Buddy] create field to map the 'lastname' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "lastname", columnDefinition = "public.Name(54) not null")
    private Object lastname;
*/
/*
    TODO [JPA Buddy] create field to map the 'additionalcontactinfo' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "additionalcontactinfo", columnDefinition = "xml")
    private Object additionalcontactinfo;
*/
/*
    TODO [JPA Buddy] create field to map the 'demographics' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "demographics", columnDefinition = "xml")
    private Object demographics;
*/
}