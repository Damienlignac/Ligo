package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "creditcard", schema = "sales")
public class Creditcard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "creditcardid", nullable = false)
	private Integer id;

	@Column(name = "cardtype", nullable = false, length = 50)
	private String cardtype;

	@Column(name = "cardnumber", nullable = false, length = 25)
	private String cardnumber;

	@Column(name = "expmonth", nullable = false)
	private Short expmonth;

	@Column(name = "expyear", nullable = false)
	private Short expyear;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Short getExpmonth() {
		return expmonth;
	}

	public void setExpmonth(Short expmonth) {
		this.expmonth = expmonth;
	}

	public Short getExpyear() {
		return expyear;
	}

	public void setExpyear(Short expyear) {
		this.expyear = expyear;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}