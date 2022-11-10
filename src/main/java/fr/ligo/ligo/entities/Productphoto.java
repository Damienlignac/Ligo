package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "productphoto", schema = "production")
public class Productphoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productphotoid", nullable = false)
	private Integer id;

	@Column(name = "thumbnailphoto")
	private byte[] thumbnailphoto;

	@Column(name = "thumbnailphotofilename", length = 50)
	private String thumbnailphotofilename;

	@Column(name = "largephoto")
	private byte[] largephoto;

	@Column(name = "largephotofilename", length = 50)
	private String largephotofilename;

	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getThumbnailphoto() {
		return thumbnailphoto;
	}

	public void setThumbnailphoto(byte[] thumbnailphoto) {
		this.thumbnailphoto = thumbnailphoto;
	}

	public String getThumbnailphotofilename() {
		return thumbnailphotofilename;
	}

	public void setThumbnailphotofilename(String thumbnailphotofilename) {
		this.thumbnailphotofilename = thumbnailphotofilename;
	}

	public byte[] getLargephoto() {
		return largephoto;
	}

	public void setLargephoto(byte[] largephoto) {
		this.largephoto = largephoto;
	}

	public String getLargephotofilename() {
		return largephotofilename;
	}

	public void setLargephotofilename(String largephotofilename) {
		this.largephotofilename = largephotofilename;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

}