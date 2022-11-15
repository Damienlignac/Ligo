package fr.ligo.ligo.entities;

import fr.ligo.ligo.services.EntityLigoSystem;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@EntityLigoSystem
@Table(name = "document", schema = "production")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Lob
	@Column(name = "documentnode", nullable = false)
	private String id;

	@Column(name = "title", nullable = false, length = 50)
	private String title;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "owner", nullable = false, referencedColumnName = "businessentityid")
	private Employee owner;

	@Column(name = "filename", nullable = false, length = 400)
	private String filename;

	@Column(name = "fileextension", length = 8)
	private String fileextension;

	@Column(name = "revision", nullable = false, length = 5)
	private String revision;

	@Column(name = "changenumber", nullable = false)
	private Integer changenumber;

	@Column(name = "status", nullable = false)
	private Short status;

	@Column(name = "documentsummary")
	@Type(type = "org.hibernate.type.TextType")
	private String documentsummary;

	@Column(name = "document")
	private byte[] document;

	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;
	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileextension() {
		return fileextension;
	}

	public void setFileextension(String fileextension) {
		this.fileextension = fileextension;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public Integer getChangenumber() {
		return changenumber;
	}

	public void setChangenumber(Integer changenumber) {
		this.changenumber = changenumber;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getDocumentsummary() {
		return documentsummary;
	}

	public void setDocumentsummary(String documentsummary) {
		this.documentsummary = documentsummary;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public UUID getRowguid() {
		return rowguid;
	}

	public void setRowguid(UUID rowguid) {
		this.rowguid = rowguid;
	}

	public Instant getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Instant modifieddate) {
		this.modifieddate = modifieddate;
	}

/*
    TODO [JPA Buddy] create field to map the 'folderflag' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "folderflag", columnDefinition = "public.Flag(1) not null")
    private Object folderflag;
*/
}