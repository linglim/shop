package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the carousel_item database table.
 * 
 */
@Entity
@Table(name="carousel_item")
@NamedQuery(name="CarouselItem.findAll", query="SELECT c FROM CarouselItem c")
public class CarouselItem extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;

	@Column(name="action_url", length=255)
	private String actionUrl;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;

	@Column(name="img_url", length=255)
	private String imgUrl;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	//bi-directional many-to-one association to CarouselView
	@ManyToOne
	@JoinColumn(name="carouse_id")
	private CarouselView carouselView;

	public CarouselItem() {
	}

//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getActionUrl() {
		return this.actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

//	public Date getCreatedAt() {
//		return this.createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public CarouselView getCarouselView() {
		return this.carouselView;
	}

	public void setCarouselView(CarouselView carouselView) {
		this.carouselView = carouselView;
	}

}