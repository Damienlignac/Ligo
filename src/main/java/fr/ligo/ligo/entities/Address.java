package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@EntityLigoSystem
@Table(name = "address", schema = "person")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addressid", nullable = false)
	private Integer id;

	@Column(name = "addressline1", nullable = false, length = 60)
	private String addressline1;

	@Column(name = "addressline2", length = 60)
	private String addressline2;

	@Column(name = "city", nullable = false, length = 30)
	private String city;

	@Column(name = "stateprovinceid", nullable = false)
	private Integer stateprovinceid;

	@Column(name = "postalcode", nullable = false, length = 15)
	private String postalcode;

	@Column(name = "spatiallocation", length = 44)
	private String spatiallocation;

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

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getStateprovinceid() {
		return stateprovinceid;
	}

	public void setStateprovinceid(Integer stateprovinceid) {
		this.stateprovinceid = stateprovinceid;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getSpatiallocation() {
		return spatiallocation;
	}

	public void setSpatiallocation(String spatiallocation) {
		this.spatiallocation = spatiallocation;
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