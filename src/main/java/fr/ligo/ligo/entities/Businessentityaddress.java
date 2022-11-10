package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "businessentityaddress", schema = "person")
public class Businessentityaddress {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private BusinessentityaddressId id;

	@MapsId("businessentityid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false)
	private Businessentity businessentityid;

	@MapsId("addressid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "addressid", nullable = false)
	private Address addressid;

	@MapsId("addresstypeid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "addresstypeid", nullable = false)
	private Addresstype addresstypeid;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public BusinessentityaddressId getId() {
		return id;
	}

	public void setId(BusinessentityaddressId id) {
		this.id = id;
	}

	public Businessentity getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Businessentity businessentityid) {
		this.businessentityid = businessentityid;
	}

	public Address getAddressid() {
		return addressid;
	}

	public void setAddressid(Address addressid) {
		this.addressid = addressid;
	}

	public Addresstype getAddresstypeid() {
		return addresstypeid;
	}

	public void setAddresstypeid(Addresstype addresstypeid) {
		this.addresstypeid = addresstypeid;
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