package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the group_specification_option database table.
 * 
 */
@Entity
@Table(name="group_specification_option")
@NamedQuery(name="GroupSpecificationOption.findAll", query="SELECT g FROM GroupSpecificationOption g")
public class GroupSpecificationOption extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	@Column(length=255)
	@JsonProperty("option_name")
	private String value;

	//bi-directional many-to-one association to Group_specification
	@ManyToOne
	@JoinColumn(name="spe_id")
	@JsonBackReference
	private Group_specification groupSpecification;

	//bi-directional many-to-one association to ProductSpecification
	@OneToMany(mappedBy="groupSpecificationOption")
	@JsonBackReference
	private List<ProductSpecification> productSpecifications;

	public GroupSpecificationOption() {
	}
//
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
//
//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Group_specification getGroupSpecification() {
		return this.groupSpecification;
	}

	public void setGroupSpecification(Group_specification groupSpecification) {
		this.groupSpecification = groupSpecification;
	}

	public List<ProductSpecification> getProductSpecifications() {
		return this.productSpecifications;
	}

	public void setProductSpecifications(List<ProductSpecification> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public ProductSpecification addProductSpecification(ProductSpecification productSpecification) {
		getProductSpecifications().add(productSpecification);
		productSpecification.setGroupSpecificationOption(this);

		return productSpecification;
	}

	public ProductSpecification removeProductSpecification(ProductSpecification productSpecification) {
		getProductSpecifications().remove(productSpecification);
		productSpecification.setGroupSpecificationOption(null);

		return productSpecification;
	}

}