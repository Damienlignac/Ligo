package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "productmodelproductdescriptionculture", schema = "production")
public class Productmodelproductdescriptionculture {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private ProductmodelproductdescriptioncultureId id;

	@MapsId("cultureid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cultureid", nullable = false)
	private Culture cultureid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public ProductmodelproductdescriptioncultureId getId() {
		return id;
	}

	public void setId(ProductmodelproductdescriptioncultureId id) {
		this.id = id;
	}

	public Culture getCultureid() {
		return cultureid;
	}

	public void setCultureid(Culture cultureid) {
		this.cultureid = cultureid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}