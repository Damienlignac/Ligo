package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityLigoSystem
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