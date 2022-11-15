package fr.ligo.ligo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import fr.ligo.ligo.services.EntityLigoSystem;

@Entity
@EntityLigoSystem
@Table(name = "unitmeasure", schema = "production")
public class Unitmeasure {
	@Id
	@Column(name = "unitmeasurecode", nullable = false, length = 3)
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