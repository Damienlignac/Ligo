package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "productmodelillustration", schema = "production")
public class Productmodelillustration {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private ProductmodelillustrationId id;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public ProductmodelillustrationId getId() {
		return id;
	}

	public void setId(ProductmodelillustrationId id) {
		this.id = id;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}