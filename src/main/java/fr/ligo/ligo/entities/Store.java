package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "store", schema = "sales")
public class Store {
	@Id
	@Column(name = "businessentityid", nullable = false)
	private Integer id;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "businessentityid", nullable = false, referencedColumnName = "businessentityid")
	private Businessentity businessentity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salespersonid")
	private Salesperson salespersonid;
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

	public Businessentity getBusinessentity() {
		return businessentity;
	}

	public void setBusinessentity(Businessentity businessentity) {
		this.businessentity = businessentity;
	}

	public Salesperson getSalespersonid() {
		return salespersonid;
	}

	public void setSalespersonid(Salesperson salespersonid) {
		this.salespersonid = salespersonid;
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

    @Column(name = "name", nullable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
    TODO [JPA Buddy] create field to map the 'demographics' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "demographics", columnDefinition = "xml")
    private Object demographics;
*/
}