package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "emailaddress", schema = "person")
public class Emailaddress {
	@EmbeddedId
	private EmailaddressId id;

	@MapsId("businessentityid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false)
	private Person businessentityid;

	@Column(name = "emailaddress", length = 50)
	private String emailaddress;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public EmailaddressId getId() {
		return id;
	}

	public void setId(EmailaddressId id) {
		this.id = id;
	}

	public Person getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Person businessentityid) {
		this.businessentityid = businessentityid;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
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