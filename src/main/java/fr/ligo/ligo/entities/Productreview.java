package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "productreview", schema = "production")
public class Productreview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productreviewid", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productid", nullable = false)
	private Product productid;

	@Column(name = "reviewdate", nullable = false)
	private Instant reviewdate;

	@Column(name = "emailaddress", nullable = false, length = 50)
	private String emailaddress;

	@Column(name = "rating", nullable = false)
	private Integer rating;

	@Column(name = "comments", length = 3850)
	private String comments;
	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductid() {
		return productid;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public Instant getReviewdate() {
		return reviewdate;
	}

	public void setReviewdate(Instant reviewdate) {
		this.reviewdate = reviewdate;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

/*
    TODO [JPA Buddy] create field to map the 'reviewername' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "reviewername", columnDefinition = "public.Name(54) not null")
    private Object reviewername;
*/
}