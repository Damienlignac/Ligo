package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "countryregioncurrency", schema = "sales")
public class Countryregioncurrency {
	@EmbeddedId
	private CountryregioncurrencyId id;

	@MapsId("countryregioncode")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "countryregioncode", nullable = false, referencedColumnName = "countryregioncode")
	private Countryregion countryregioncode;

	@MapsId("currencycode")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "currencycode", nullable = false)
	private Currency currencycode;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public CountryregioncurrencyId getId() {
		return id;
	}

	public void setId(CountryregioncurrencyId id) {
		this.id = id;
	}

	public Countryregion getCountryregioncode() {
		return countryregioncode;
	}

	public void setCountryregioncode(Countryregion countryregioncode) {
		this.countryregioncode = countryregioncode;
	}

	public Currency getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(Currency currencycode) {
		this.currencycode = currencycode;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}