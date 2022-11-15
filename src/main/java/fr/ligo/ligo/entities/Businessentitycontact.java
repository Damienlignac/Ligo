package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@EntityLigoSystem
@Table(name = "businessentitycontact", schema = "person")
public class Businessentitycontact {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private BusinessentitycontactId id;

	@MapsId("businessentityid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false)
	private Businessentity businessentityid;

	@MapsId("personid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "personid", nullable = false)
	private Person personid;

	@MapsId("contacttypeid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "contacttypeid", nullable = false)
	private Contacttype contacttypeid;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public BusinessentitycontactId getId() {
		return id;
	}

	public void setId(BusinessentitycontactId id) {
		this.id = id;
	}

	public Businessentity getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Businessentity businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Person getPersonid() {
		return personid;
	}

	public void setPersonid(Person personid) {
		this.personid = personid;
	}

	public Contacttype getContacttypeid() {
		return contacttypeid;
	}

	public void setContacttypeid(Contacttype contacttypeid) {
		this.contacttypeid = contacttypeid;
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

}