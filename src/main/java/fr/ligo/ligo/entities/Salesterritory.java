package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "salesterritory", schema = "sales")
public class Salesterritory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "territoryid", nullable = false)
	private Long territoryid;

	@Column(name = "countryregioncode", nullable = false, length = 3)
	private String countryregioncode;

	@Column(name = "group", nullable = false, length = 50)
	private String group;

	@Column(name = "salesytd", nullable = false)
	private BigDecimal salesytd;

	@Column(name = "saleslastyear", nullable = false)
	private BigDecimal saleslastyear;

	@Column(name = "costytd", nullable = false)
	private BigDecimal costytd;

	@Column(name = "costlastyear", nullable = false)
	private BigDecimal costlastyear;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

	public UUID getRowguid() {
		return rowguid;
	}

	public void setRowguid(UUID rowguid) {
		this.rowguid = rowguid;
	}

	public BigDecimal getCostlastyear() {
		return costlastyear;
	}

	public void setCostlastyear(BigDecimal costlastyear) {
		this.costlastyear = costlastyear;
	}

	public BigDecimal getCostytd() {
		return costytd;
	}

	public void setCostytd(BigDecimal costytd) {
		this.costytd = costytd;
	}

	public BigDecimal getSaleslastyear() {
		return saleslastyear;
	}

	public void setSaleslastyear(BigDecimal saleslastyear) {
		this.saleslastyear = saleslastyear;
	}

	public BigDecimal getSalesytd() {
		return salesytd;
	}

	public void setSalesytd(BigDecimal salesytd) {
		this.salesytd = salesytd;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCountryregioncode() {
		return countryregioncode;
	}

	public Long getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(Long territoryid) {
		this.territoryid = territoryid;
	}

	public void setCountryregioncode(String countryregioncode) {
		this.countryregioncode = countryregioncode;
	}

	//TODO [JPA Buddy] generate columns from DB
/*
    TODO [JPA Buddy] create field to map the 'name' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "name", columnDefinition = "public.Name(54) not null")
    private java.lang.Object name;
*/
}