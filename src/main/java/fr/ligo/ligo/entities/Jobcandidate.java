package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "jobcandidate", schema = "humanresources")
public class Jobcandidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobcandidateid", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "businessentityid")
	private Employee businessentityid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Employee businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

/*
    TODO [JPA Buddy] create field to map the 'resume' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "resume", columnDefinition = "xml")
    private Object resume;
*/
}