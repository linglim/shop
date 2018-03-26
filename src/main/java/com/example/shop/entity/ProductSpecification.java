package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the product_specification database table.
 * 
 */
@Entity
@Table(name="product_specification")
@NamedQuery(name="ProductSpecification.findAll", query="SELECT p FROM ProductSpecification p")
public class ProductSpecification extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;

	@Column(length=255)
	@JsonBackReference
	private String name;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	@JsonBackReference
	@JsonIgnore
	private Product product;

	//bi-directional many-to-one association to Group_specification
	@ManyToOne

	@JoinColumn(name="specification_id")
	
	private Group_specification groupSpecification;
	

	//bi-directional many-to-one association to GroupSpecificationOption
	@ManyToOne
	@JoinColumn(name="specification_value")
	private GroupSpecificationOption groupSpecificationOption;

	public ProductSpecification() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Group_specification getGroupSpecification() {
		return this.groupSpecification;
	}

	public void setGroupSpecification(Group_specification groupSpecification) {
		this.groupSpecification = groupSpecification;
	}

	public GroupSpecificationOption getGroupSpecificationOption() {
		return this.groupSpecificationOption;
	}

	public void setGroupSpecificationOption(GroupSpecificationOption groupSpecificationOption) {
		this.groupSpecificationOption = groupSpecificationOption;
	}

}