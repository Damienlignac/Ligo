package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "personphone", schema = "person")
public class Personphone {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private PersonphoneId id;

	@MapsId("businessentityid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false)
	private Person businessentityid;

	@MapsId("phonenumbertypeid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "phonenumbertypeid", nullable = false)
	private Phonenumbertype phonenumbertypeid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public PersonphoneId getId() {
		return id;
	}

	public void setId(PersonphoneId id) {
		this.id = id;
	}

	public Person getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Person businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Phonenumbertype getPhonenumbertypeid() {
		return phonenumbertypeid;
	}

	public void setPhonenumbertypeid(Phonenumbertype phonenumbertypeid) {
		this.phonenumbertypeid = phonenumbertypeid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}