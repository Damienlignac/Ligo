package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "stateprovince", schema = "person")
public class Stateprovince {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stateprovinceid", nullable = false)
	private Integer id;

	@Column(name = "stateprovincecode", nullable = false, length = 3)
	private String stateprovincecode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "countryregioncode", nullable = false)
	private Countryregion countryregioncode;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "territoryid", nullable = false, referencedColumnName = "territoryid")
	private Salesterritory territoryid;
	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStateprovincecode() {
		return stateprovincecode;
	}

	public void setStateprovincecode(String stateprovincecode) {
		this.stateprovincecode = stateprovincecode;
	}

	public Countryregion getCountryregioncode() {
		return countryregioncode;
	}

	public void setCountryregioncode(Countryregion countryregioncode) {
		this.countryregioncode = countryregioncode;
	}

	public Salesterritory getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(Salesterritory territoryid) {
		this.territoryid = territoryid;
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

/*
    TODO [JPA Buddy] create field to map the 'isonlystateprovinceflag' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "isonlystateprovinceflag", columnDefinition = "public.Flag(1) not null")
    private Object isonlystateprovinceflag;
*/
    @Column(name = "name", nullable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}