package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalTime;
import fr.ligo.ligo.services.EntityLigoSystem;
@Entity
@EntityLigoSystem
@Table(name = "shift", schema = "humanresources")
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shiftid", nullable = false)
	private Integer id;

	@Column(name = "starttime", nullable = false)
	private LocalTime starttime;

	@Column(name = "endtime", nullable = false)
	private LocalTime endtime;
	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getStarttime() {
		return starttime;
	}

	public void setStarttime(LocalTime starttime) {
		this.starttime = starttime;
	}

	public LocalTime getEndtime() {
		return endtime;
	}

	public void setEndtime(LocalTime endtime) {
		this.endtime = endtime;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

    @Column(name = "name", nullable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}