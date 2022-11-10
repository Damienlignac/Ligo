package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "personcreditcard", schema = "sales")
public class Personcreditcard {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private PersoncreditcardId id;

	@MapsId("creditcardid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "creditcardid", nullable = false)
	private Creditcard creditcardid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public PersoncreditcardId getId() {
		return id;
	}

	public void setId(PersoncreditcardId id) {
		this.id = id;
	}

	public Creditcard getCreditcardid() {
		return creditcardid;
	}

	public void setCreditcardid(Creditcard creditcardid) {
		this.creditcardid = creditcardid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}