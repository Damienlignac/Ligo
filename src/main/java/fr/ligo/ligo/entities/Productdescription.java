package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@EntityLigoSystem
@Table(name = "productdescription", schema = "production")
public class Productdescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productdescriptionid", nullable = false)
	private Integer id;

	@Column(name = "description", nullable = false, length = 400)
	private String description;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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