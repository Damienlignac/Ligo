package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "productmodel", schema = "production")
public class Productmodel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productmodelid", nullable = false)
	private Integer id;

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

    @Column(name = "name", nullable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
    TODO [JPA Buddy] create field to map the 'catalogdescription' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "catalogdescription", columnDefinition = "xml")
    private Object catalogdescription;
*/
/*
    TODO [JPA Buddy] create field to map the 'instructions' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "instructions", columnDefinition = "xml")
    private Object instructions;
*/
}