package fr.ligo.ligo.entities;
import fr.ligo.ligo.services.EntityLigoSystem;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@EntityLigoSystem
@Table(name = "workorderrouting", schema = "production")
public class Workorderrouting {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	private WorkorderroutingId id;

	@MapsId("workorderid")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "workorderid", nullable = false)
	private Workorder workorderid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "locationid", nullable = false)
	private Location locationid;

	@Column(name = "scheduledstartdate", nullable = false)
	private Instant scheduledstartdate;

	@Column(name = "scheduledenddate", nullable = false)
	private Instant scheduledenddate;

	@Column(name = "actualstartdate")
	private Instant actualstartdate;

	@Column(name = "actualenddate")
	private Instant actualenddate;

	@Column(name = "actualresourcehrs", precision = 9, scale = 4)
	private BigDecimal actualresourcehrs;

	@Column(name = "plannedcost", nullable = false)
	private BigDecimal plannedcost;

	@Column(name = "actualcost")
	private BigDecimal actualcost;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public WorkorderroutingId getId() {
		return id;
	}

	public void setId(WorkorderroutingId id) {
		this.id = id;
	}

	public Workorder getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(Workorder workorderid) {
		this.workorderid = workorderid;
	}

	public Location getLocationid() {
		return locationid;
	}

	public void setLocationid(Location locationid) {
		this.locationid = locationid;
	}

	public Instant getScheduledstartdate() {
		return scheduledstartdate;
	}

	public void setScheduledstartdate(Instant scheduledstartdate) {
		this.scheduledstartdate = scheduledstartdate;
	}

	public Instant getScheduledenddate() {
		return scheduledenddate;
	}

	public void setScheduledenddate(Instant scheduledenddate) {
		this.scheduledenddate = scheduledenddate;
	}

	public Instant getActualstartdate() {
		return actualstartdate;
	}

	public void setActualstartdate(Instant actualstartdate) {
		this.actualstartdate = actualstartdate;
	}

	public Instant getActualenddate() {
		return actualenddate;
	}

	public void setActualenddate(Instant actualenddate) {
		this.actualenddate = actualenddate;
	}

	public BigDecimal getActualresourcehrs() {
		return actualresourcehrs;
	}

	public void setActualresourcehrs(BigDecimal actualresourcehrs) {
		this.actualresourcehrs = actualresourcehrs;
	}

	public BigDecimal getPlannedcost() {
		return plannedcost;
	}

	public void setPlannedcost(BigDecimal plannedcost) {
		this.plannedcost = plannedcost;
	}

	public BigDecimal getActualcost() {
		return actualcost;
	}

	public void setActualcost(BigDecimal actualcost) {
		this.actualcost = actualcost;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}