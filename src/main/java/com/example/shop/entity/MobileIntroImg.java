package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mobile_intro_img database table.
 * 
 */
@Entity
@Table(name="mobile_intro_img")
@NamedQuery(name="MobileIntroImg.findAll", query="SELECT m FROM MobileIntroImg m")
public class MobileIntroImg extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;
//
	private float ratio;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	@Column(length=255)
	private String url;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public MobileIntroImg() {
	}

//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Date getCreatedAt() {
//		return this.createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

	public float getRatio() {
		return this.ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}