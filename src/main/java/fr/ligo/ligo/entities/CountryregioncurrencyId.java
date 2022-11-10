package fr.ligo.ligo.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryregioncurrencyId implements Serializable {
	private static final long serialVersionUID = -6908024542695404962L;
	@Column(name = "countryregioncode", nullable = false, length = 3)
	private String countryregioncode;

	@Column(name = "currencycode", nullable = false, length = 3)
	private String currencycode;

	public String getCountryregioncode() {
		return countryregioncode;
	}

	public void setCountryregioncode(String countryregioncode) {
		this.countryregioncode = countryregioncode;
	}

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CountryregioncurrencyId entity = (CountryregioncurrencyId) o;
		return Objects.equals(this.currencycode, entity.currencycode) &&
				Objects.equals(this.countryregioncode, entity.countryregioncode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(currencycode, countryregioncode);
	}

}