package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "productproductphoto", schema = "production")
public class Productproductphoto {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private ProductproductphotoId id;

	@MapsId("productid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false)
	private Product productid;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public ProductproductphotoId getId() {
		return id;
	}

	public void setId(ProductproductphotoId id) {
		this.id = id;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

/*
    TODO [JPA Buddy] create field to map the '\"primary\"' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "\"primary\"", columnDefinition = "public.Flag(1) not null")
    private Object primary;
*/
}