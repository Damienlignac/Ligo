package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@EntityLigoSystem
@Table(name = "productinventory", schema = "production")
public class Productinventory {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private ProductinventoryId id;

	@MapsId("productid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false)
	private Product productid;

	@MapsId("locationid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "locationid", nullable = false)
	private Location locationid;

	@Column(name = "shelf", nullable = false, length = 10)
	private String shelf;

	@Column(name = "bin", nullable = false)
	private Short bin;

	@Column(name = "quantity", nullable = false)
	private Short quantity;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public ProductinventoryId getId() {
		return id;
	}

	public void setId(ProductinventoryId id) {
		this.id = id;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public Location getLocationid() {
		return locationid;
	}

	public void setLocationid(Location locationid) {
		this.locationid = locationid;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public Short getBin() {
		return bin;
	}

	public void setBin(Short bin) {
		this.bin = bin;
	}

	public Short getQuantity() {
		return quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
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