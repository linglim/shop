package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product_group database table.
 * 
 */
@Entity
@Table(name="product_group")
@NamedQuery(name="ProductGroup.findAll", query="SELECT p FROM ProductGroup p")
public class ProductGroup extends Base implements Serializable {
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
	@JsonProperty("feature_name")  
	private String name;

	@Column(name="shop_category_id")
	@JsonBackReference
	private int shopCategoryId;

	@Column(name="shop_id")
	@JsonBackReference
	private int shopId;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	//bi-directional many-to-one association to Group_specification
	@OneToMany(mappedBy="productGroup")
	private List<Group_specification> groupSpecifications;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productGroup")
	@JsonBackReference
	private List<Product> products;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	public ProductGroup() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShopCategoryId() {
		return this.shopCategoryId;
	}

	public void setShopCategoryId(int shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}

	public int getShopId() {
		return this.shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public List<Group_specification> getGroupSpecifications() {
		return this.groupSpecifications;
	}

	public void setGroupSpecifications(List<Group_specification> groupSpecifications) {
		this.groupSpecifications = groupSpecifications;
	}

	public Group_specification addGroupSpecification(Group_specification groupSpecification) {
		getGroupSpecifications().add(groupSpecification);
		groupSpecification.setProductGroup(this);

		return groupSpecification;
	}

	public Group_specification removeGroupSpecification(Group_specification groupSpecification) {
		getGroupSpecifications().remove(groupSpecification);
		groupSpecification.setProductGroup(null);

		return groupSpecification;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductGroup(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductGroup(null);

		return product;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}