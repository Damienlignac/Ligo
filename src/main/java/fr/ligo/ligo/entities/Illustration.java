package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "illustration", schema = "production")
public class Illustration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "illustrationid", nullable = false)
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

/*
    TODO [JPA Buddy] create field to map the 'diagram' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "diagram", columnDefinition = "xml")
    private Object diagram;
*/
}