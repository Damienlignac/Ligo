package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "salesreason", schema = "sales")
public class Salesreason {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salesreasonid", nullable = false)
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
/*
    TODO [JPA Buddy] create field to map the 'reasontype' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "reasontype", columnDefinition = "public.Name(54) not null")
    private Object reasontype;
*/
}