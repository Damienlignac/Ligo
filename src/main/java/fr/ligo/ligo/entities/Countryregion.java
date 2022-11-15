package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "countryregion", schema = "person")
public class Countryregion {
	@Id
	@Column(name = "countryregioncode", nullable = false, length = 3)
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