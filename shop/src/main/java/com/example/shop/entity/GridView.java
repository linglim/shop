package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the grid_view database table.
 * 
 */
@Entity
@Table(name="grid_view")
@NamedQuery(name="GridView.findAll", query="SELECT g FROM GridView g")
public class GridView extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;
	private float ratio;
	@Column(length=255)
	private String orientation;

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

	@Column(name="parent_id")
	private long parentId;

	@Column(name="style_id", length=255)
	private String styleId;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	private int weight;

	//bi-directional many-to-one association to GridItem
	@OneToMany(mappedBy="gridView")
	private List<GridItem> gridItems;

	//bi-directional many-to-one association to Indexconfig
	@ManyToOne
	@JoinColumn(name="conf_id")
	private Indexconfig indexconfig;

	public GridView() {
	}

//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

//	public Date getCreatedAt() {
//		return this.createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

	public String getOrientation() {
		return this.orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getStyleId() {
		return this.styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<GridItem> getGridItems() {
		return this.gridItems;
	}

	public void setGridItems(List<GridItem> gridItems) {
		this.gridItems = gridItems;
	}

	public GridItem addGridItem(GridItem gridItem) {
		getGridItems().add(gridItem);
		gridItem.setGridView(this);

		return gridItem;
	}

	public GridItem removeGridItem(GridItem gridItem) {
		getGridItems().remove(gridItem);
		gridItem.setGridView(null);

		return gridItem;
	}

	public Indexconfig getIndexconfig() {
		return this.indexconfig;
	}

	public void setIndexconfig(Indexconfig indexconfig) {
		this.indexconfig = indexconfig;
	}

}