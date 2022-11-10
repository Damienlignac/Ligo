package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "currencyrate", schema = "sales")
public class Currencyrate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "currencyrateid", nullable = false)
	private Integer id;

	@Column(name = "currencyratedate", nullable = false)
	private Instant currencyratedate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fromcurrencycode", nullable = false)
	private Currency fromcurrencycode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tocurrencycode", nullable = false)
	private Currency tocurrencycode;

	@Column(name = "averagerate", nullable = false)
	private BigDecimal averagerate;

	@Column(name = "endofdayrate", nullable = false)
	private BigDecimal endofdayrate;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getCurrencyratedate() {
		return currencyratedate;
	}

	public void setCurrencyratedate(Instant currencyratedate) {
		this.currencyratedate = currencyratedate;
	}

	public Currency getFromcurrencycode() {
		return fromcurrencycode;
	}

	public void setFromcurrencycode(Currency fromcurrencycode) {
		this.fromcurrencycode = fromcurrencycode;
	}

	public Currency getTocurrencycode() {
		return tocurrencycode;
	}

	public void setTocurrencycode(Currency tocurrencycode) {
		this.tocurrencycode = tocurrencycode;
	}

	public BigDecimal getAveragerate() {
		return averagerate;
	}

	public void setAveragerate(BigDecimal averagerate) {
		this.averagerate = averagerate;
	}

	public BigDecimal getEndofdayrate() {
		return endofdayrate;
	}

	public void setEndofdayrate(BigDecimal endofdayrate) {
		this.endofdayrate = endofdayrate;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}