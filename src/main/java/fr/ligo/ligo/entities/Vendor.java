package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "vendor", schema = "purchasing")
public class Vendor {
	@Id
	@Column(name = "businessentityid", nullable = false)
	private Integer id;

	@Column(name = "purchasingwebserviceurl", length = 1024)
	private String purchasingwebserviceurl;

	@Column(name = "creditrating", nullable = false)
	private Short creditrating;
	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getCreditrating() {
		return creditrating;
	}

	public void setCreditrating(Short creditrating) {
		this.creditrating = creditrating;
	}

	public String getPurchasingwebserviceurl() {
		return purchasingwebserviceurl;
	}

	public void setPurchasingwebserviceurl(String purchasingwebserviceurl) {
		this.purchasingwebserviceurl = purchasingwebserviceurl;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

/*
    TODO [JPA Buddy] create field to map the 'accountnumber' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "accountnumber", columnDefinition = "public.AccountNumber(19) not null")
    private Object accountnumber;
*/
    @Column(name = "name", nullable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
    TODO [JPA Buddy] create field to map the 'preferredvendorstatus' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "preferredvendorstatus", columnDefinition = "public.Flag(1) not null")
    private Object preferredvendorstatus;
*/
/*
    TODO [JPA Buddy] create field to map the 'activeflag' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "activeflag", columnDefinition = "public.Flag(1) not null")
    private Object activeflag;
*/
}