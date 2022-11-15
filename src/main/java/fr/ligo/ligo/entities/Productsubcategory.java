package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@EntityLigoSystem
@Table(name = "productsubcategory", schema = "production")
public class Productsubcategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productsubcategoryid", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productcategoryid", nullable = false)
	private Productcategory productcategoryid;

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

	public Productcategory getProductcategoryid() {
		return productcategoryid;
	}

	public void setProductcategoryid(Productcategory productcategoryid) {
		this.productcategoryid = productcategoryid;
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
}