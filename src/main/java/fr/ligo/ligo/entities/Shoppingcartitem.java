package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "shoppingcartitem", schema = "sales")
public class Shoppingcartitem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shoppingcartitemid", nullable = false)
	private Integer id;

	@Column(name = "shoppingcartid", nullable = false, length = 50)
	private String shoppingcartid;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false, referencedColumnName = "productid")
	private Product productid;

	@Column(name = "datecreated", nullable = false)
	private Instant datecreated;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShoppingcartid() {
		return shoppingcartid;
	}

	public void setShoppingcartid(String shoppingcartid) {
		this.shoppingcartid = shoppingcartid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public Instant getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Instant datecreated) {
		this.datecreated = datecreated;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}