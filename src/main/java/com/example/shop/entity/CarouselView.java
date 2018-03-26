package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the carousel_view database table.
 * 
 */
@Entity
@Table(name="carousel_view")
@NamedQuery(name="CarouselView.findAll", query="SELECT c FROM CarouselView c")
public class CarouselView extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;

	private float duration;

	private float ratio;

	@Column(name="style_id", length=255)
	private String styleId;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	//bi-directional many-to-one association to CarouselItem
	@OneToMany(mappedBy="carouselView")
	private List<CarouselItem> carouselItems;

	//bi-directional many-to-one association to Indexconfig
	@ManyToOne
	@JoinColumn(name="conf_id")
	private Indexconfig indexconfig;

	public CarouselView() {
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

	public float getDuration() {
		return this.duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public float getRatio() {
		return this.ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
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

	public List<CarouselItem> getCarouselItems() {
		return this.carouselItems;
	}

	public void setCarouselItems(List<CarouselItem> carouselItems) {
		this.carouselItems = carouselItems;
	}

	public CarouselItem addCarouselItem(CarouselItem carouselItem) {
		getCarouselItems().add(carouselItem);
		carouselItem.setCarouselView(this);

		return carouselItem;
	}

	public CarouselItem removeCarouselItem(CarouselItem carouselItem) {
		getCarouselItems().remove(carouselItem);
		carouselItem.setCarouselView(null);

		return carouselItem;
	}

	public Indexconfig getIndexconfig() {
		return this.indexconfig;
	}

	public void setIndexconfig(Indexconfig indexconfig) {
		this.indexconfig = indexconfig;
	}

}