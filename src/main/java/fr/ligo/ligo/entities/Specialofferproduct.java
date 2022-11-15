package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@EntityLigoSystem
@Table(name = "specialofferproduct", schema = "sales")
public class Specialofferproduct {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private SpecialofferproductId id;

	@MapsId("specialofferid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "specialofferid", nullable = false)
	private Specialoffer specialofferid;

	@MapsId("productid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false, referencedColumnName = "productid")
	private Product productid;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public SpecialofferproductId getId() {
		return id;
	}

	public void setId(SpecialofferproductId id) {
		this.id = id;
	}

	public Specialoffer getSpecialofferid() {
		return specialofferid;
	}

	public void setSpecialofferid(Specialoffer specialofferid) {
		this.specialofferid = specialofferid;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
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