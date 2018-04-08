package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends Base implements Serializable {
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
	private String name;

	private float price;

	@Column(name="product_comission_id")
	private long productComissionId;

	@Column(name="shop_category_id")
	private int shopCategoryId;

	@Column(name="shop_id")
	private int shopId;

	@Column(name="sub_title", length=255)
	@JsonProperty("sub_title")
	private String subTitle;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="product")
	
	private List<Comment> comments;

	//bi-directional many-to-one association to MobileIntroImg
	@OneToMany(mappedBy="product")
	@JsonProperty("intro_imgs")
	private List<MobileIntroImg> mobileIntroImgs;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonIgnore
	private Category category;

	//bi-directional many-to-one association to ProductGroup
	@ManyToOne
	@JoinColumn(name="product_group_id")
	@JsonIgnore
	private ProductGroup productGroup;

	//bi-directional many-to-one association to ProductInfo
	@OneToMany(mappedBy="product")
	@JsonProperty("product_info")
	private List<ProductInfo> productInfos;

	//bi-directional many-to-one association to ProductSpecification
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<ProductSpecification> productSpecifications;

	public Product() {
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

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getProductComissionId() {
		return this.productComissionId;
	}

	public void setProductComissionId(long productComissionId) {
		this.productComissionId = productComissionId;
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

	public String getSubTitle() {
		return this.subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProduct(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProduct(null);

		return comment;
	}

	public List<MobileIntroImg> getMobileIntroImgs() {
		return this.mobileIntroImgs;
	}

	public void setMobileIntroImgs(List<MobileIntroImg> mobileIntroImgs) {
		this.mobileIntroImgs = mobileIntroImgs;
	}

	public MobileIntroImg addMobileIntroImg(MobileIntroImg mobileIntroImg) {
		getMobileIntroImgs().add(mobileIntroImg);
		mobileIntroImg.setProduct(this);

		return mobileIntroImg;
	}

	public MobileIntroImg removeMobileIntroImg(MobileIntroImg mobileIntroImg) {
		getMobileIntroImgs().remove(mobileIntroImg);
		mobileIntroImg.setProduct(null);

		return mobileIntroImg;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductGroup getProductGroup() {
		return this.productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}

	public List<ProductInfo> getProductInfos() {
		return this.productInfos;
	}

	public void setProductInfos(List<ProductInfo> productInfos) {
		this.productInfos = productInfos;
	}

	public ProductInfo addProductInfo(ProductInfo productInfo) {
		getProductInfos().add(productInfo);
		productInfo.setProduct(this);

		return productInfo;
	}

	public ProductInfo removeProductInfo(ProductInfo productInfo) {
		getProductInfos().remove(productInfo);
		productInfo.setProduct(null);

		return productInfo;
	}

	public List<ProductSpecification> getProductSpecifications() {
		return this.productSpecifications;
	}

	public void setProductSpecifications(List<ProductSpecification> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public ProductSpecification addProductSpecification(ProductSpecification productSpecification) {
		getProductSpecifications().add(productSpecification);
		productSpecification.setProduct(this);

		return productSpecification;
	}

	public ProductSpecification removeProductSpecification(ProductSpecification productSpecification) {
		getProductSpecifications().remove(productSpecification);
		productSpecification.setProduct(null);

		return productSpecification;
	}

}