package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the product_info database table.
 * 
 */
@Entity
@Table(name="product_info")
@NamedQuery(name="ProductInfo.findAll", query="SELECT p FROM ProductInfo p")
public class ProductInfo extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;

	@Column(name="info_name", length=255)
	private String infoName;

	@Column(name="info_value", length=255)
	private String infoValue;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	@JsonBackReference
	private Product product;

	public ProductInfo() {
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

	public String getInfoName() {
		return this.infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public String getInfoValue() {
		return this.infoValue;
	}

	public void setInfoValue(String infoValue) {
		this.infoValue = infoValue;
	}

//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}