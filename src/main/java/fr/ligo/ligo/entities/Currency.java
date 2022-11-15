package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "currency", schema = "sales")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "currencycode", nullable = false, length = 3)
	private String id;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

    @Column(name = "name", nullable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}