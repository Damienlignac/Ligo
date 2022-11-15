package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "scrapreason", schema = "production")
public class Scrapreason {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scrapreasonid", nullable = false)
	private Integer id;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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