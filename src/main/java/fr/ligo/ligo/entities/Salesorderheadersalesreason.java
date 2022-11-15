package fr.ligo.ligo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.Instant;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "salesorderheadersalesreason", schema = "sales")
public class Salesorderheadersalesreason {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private SalesorderheadersalesreasonId id;

	@MapsId("salesorderid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "salesorderid", nullable = false)
	private Salesorderheader salesorderid;

	@MapsId("salesreasonid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "salesreasonid", nullable = false)
	private Salesreason salesreasonid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public SalesorderheadersalesreasonId getId() {
		return id;
	}

	public void setId(SalesorderheadersalesreasonId id) {
		this.id = id;
	}

	public Salesorderheader getSalesorderid() {
		return salesorderid;
	}

	public void setSalesorderid(Salesorderheader salesorderid) {
		this.salesorderid = salesorderid;
	}

	public Salesreason getSalesreasonid() {
		return salesreasonid;
	}

	public void setSalesreasonid(Salesreason salesreasonid) {
		this.salesreasonid = salesreasonid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}