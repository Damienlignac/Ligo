package fr.ligo.ligo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "product", schema = "production")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid", nullable = false)
	private Integer id;

	@Column(name = "productnumber", nullable = false, length = 25)
	private String productnumber;

	@Column(name = "color", length = 15)
	private String color;

	@Column(name = "safetystocklevel", nullable = false)
	private Short safetystocklevel;

	@Column(name = "reorderpoint", nullable = false)
	private Short reorderpoint;

	@Column(name = "standardcost", nullable = false)
	private BigDecimal standardcost;

	@Column(name = "listprice", nullable = false)
	private BigDecimal listprice;

	@Column(name = "size", length = 5)
	private String size;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sizeunitmeasurecode")
	private Unitmeasure sizeunitmeasurecode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weightunitmeasurecode")
	private Unitmeasure weightunitmeasurecode;

	@Column(name = "weight", precision = 8, scale = 2)
	private BigDecimal weight;

	@Column(name = "daystomanufacture", nullable = false)
	private Integer daystomanufacture;

	@Column(name = "productline", length = 2)
	private String productline;

	@Column(name = "class", length = 2)
	private String classField;

	@Column(name = "style", length = 2)
	private String style;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productsubcategoryid")
	private Productsubcategory productsubcategoryid;

	@Column(name = "productmodelid")
	private Integer productmodelid;
	@Column(name = "discontinueddate")
	private Instant discontinueddate;

	@Column(name = "sellstartdate", nullable = false)
	private Instant sellstartdate;
	@Column(name = "rowguid", nullable = false)
	private UUID rowguid;

	@Column(name = "sellenddate")
	private Instant sellenddate;
	@Column(name = "modifieddate", nullable = false)
	private Instant modifieddate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Short getSafetystocklevel() {
		return safetystocklevel;
	}

	public void setSafetystocklevel(Short safetystocklevel) {
		this.safetystocklevel = safetystocklevel;
	}

	public Short getReorderpoint() {
		return reorderpoint;
	}

	public void setReorderpoint(Short reorderpoint) {
		this.reorderpoint = reorderpoint;
	}

	public BigDecimal getStandardcost() {
		return standardcost;
	}

	public void setStandardcost(BigDecimal standardcost) {
		this.standardcost = standardcost;
	}

	public BigDecimal getListprice() {
		return listprice;
	}

	public void setListprice(BigDecimal listprice) {
		this.listprice = listprice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Unitmeasure getSizeunitmeasurecode() {
		return sizeunitmeasurecode;
	}

	public void setSizeunitmeasurecode(Unitmeasure sizeunitmeasurecode) {
		this.sizeunitmeasurecode = sizeunitmeasurecode;
	}

	public Unitmeasure getWeightunitmeasurecode() {
		return weightunitmeasurecode;
	}

	public void setWeightunitmeasurecode(Unitmeasure weightunitmeasurecode) {
		this.weightunitmeasurecode = weightunitmeasurecode;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Integer getDaystomanufacture() {
		return daystomanufacture;
	}

	public void setDaystomanufacture(Integer daystomanufacture) {
		this.daystomanufacture = daystomanufacture;
	}

	public String getProductline() {
		return productline;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public String getClassField() {
		return classField;
	}

	public void setClassField(String classField) {
		this.classField = classField;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Productsubcategory getProductsubcategoryid() {
		return productsubcategoryid;
	}

	public void setProductsubcategoryid(Productsubcategory productsubcategoryid) {
		this.productsubcategoryid = productsubcategoryid;
	}

	public Integer getProductmodelid() {
		return productmodelid;
	}

	public void setProductmodelid(Integer productmodelid) {
		this.productmodelid = productmodelid;
	}

	public Instant getSellstartdate() {
		return sellstartdate;
	}

	public void setSellstartdate(Instant sellstartdate) {
		this.sellstartdate = sellstartdate;
	}

	public Instant getSellenddate() {
		return sellenddate;
	}

	public void setSellenddate(Instant sellenddate) {
		this.sellenddate = sellenddate;
	}

	public Instant getDiscontinueddate() {
		return discontinueddate;
	}

	public void setDiscontinueddate(Instant discontinueddate) {
		this.discontinueddate = discontinueddate;
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

    @Column(name = "name", nullable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
    TODO [JPA Buddy] create field to map the 'makeflag' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "makeflag", columnDefinition = "public.Flag(1) not null")
    private Object makeflag;
*/
/*
    TODO [JPA Buddy] create field to map the 'finishedgoodsflag' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "finishedgoodsflag", columnDefinition = "public.Flag(1) not null")
    private Object finishedgoodsflag;
*/
}