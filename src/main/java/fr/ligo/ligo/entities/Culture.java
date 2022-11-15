package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "culture", schema = "production")
public class Culture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cultureid", nullable = false, length = 6)
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