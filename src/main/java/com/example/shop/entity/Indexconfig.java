package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the indexconfig database table.
 * 
 */
@Entity
@Table(name="indexconfig")
//@NamedQuery(name="Indexconfig.findAll", query="SELECT i FROM Indexconfig i")
public class Indexconfig extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;

	private float rato;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	
	//bi-directional many-to-one association to CarouselView
	@OneToMany(mappedBy="indexconfig")
	private List<CarouselView> carouselViews;

	//bi-directional many-to-one association to GridView
	@OneToMany(mappedBy="indexconfig")
	private List<GridView> gridViews;
	
	public Indexconfig() {
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

	public float getRato() {
		return this.rato;
	}

	public void setRato(float rato) {
		this.rato = rato;
	}

//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
	
	
	public List<CarouselView> getCarouselViews() {
		return this.carouselViews;
	}

	public void setCarouselViews(List<CarouselView> carouselViews) {
		this.carouselViews = carouselViews;
	}

	public CarouselView addCarouselView(CarouselView carouselView) {
		getCarouselViews().add(carouselView);
		carouselView.setIndexconfig(this);

		return carouselView;
	}

	public CarouselView removeCarouselView(CarouselView carouselView) {
		getCarouselViews().remove(carouselView);
		carouselView.setIndexconfig(null);

		return carouselView;
	}

	public List<GridView> getGridViews() {
		return this.gridViews;
	}

	public void setGridViews(List<GridView> gridViews) {
		this.gridViews = gridViews;
	}

	public GridView addGridView(GridView gridView) {
		getGridViews().add(gridView);
		gridView.setIndexconfig(this);

		return gridView;
	}

	public GridView removeGridView(GridView gridView) {
		getGridViews().remove(gridView);
		gridView.setIndexconfig(null);

		return gridView;
	}


}