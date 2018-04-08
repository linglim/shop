package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the `group_ specification` database table.
 * 
 */
@Entity
@Table(name="`group_ specification`")
@NamedQuery(name="Group_specification.findAll", query="SELECT g FROM Group_specification g")
public class Group_specification extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;

	@Column(length=255)
	private String name;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;

	//bi-directional many-to-one association to ProductGroup
	@ManyToOne
	@JoinColumn(name="group_id")
	@JsonBackReference
	private ProductGroup productGroup;

	//bi-directional many-to-one association to GroupSpecificationOption
	@OneToMany(mappedBy="groupSpecification")
	@JsonBackReference
	private List<GroupSpecificationOption> groupSpecificationOptions;

	//bi-directional many-to-one association to ProductSpecification
	@OneToMany(mappedBy="groupSpecification")
	@JsonBackReference
	private List<ProductSpecification> productSpecifications;

	public Group_specification() {
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

	public ProductGroup getProductGroup() {
		return this.productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}

	public List<GroupSpecificationOption> getGroupSpecificationOptions() {
		return this.groupSpecificationOptions;
	}

	public void setGroupSpecificationOptions(List<GroupSpecificationOption> groupSpecificationOptions) {
		this.groupSpecificationOptions = groupSpecificationOptions;
	}

	public GroupSpecificationOption addGroupSpecificationOption(GroupSpecificationOption groupSpecificationOption) {
		getGroupSpecificationOptions().add(groupSpecificationOption);
		groupSpecificationOption.setGroupSpecification(this);

		return groupSpecificationOption;
	}

	public GroupSpecificationOption removeGroupSpecificationOption(GroupSpecificationOption groupSpecificationOption) {
		getGroupSpecificationOptions().remove(groupSpecificationOption);
		groupSpecificationOption.setGroupSpecification(null);

		return groupSpecificationOption;
	}

	public List<ProductSpecification> getProductSpecifications() {
		return this.productSpecifications;
	}

	public void setProductSpecifications(List<ProductSpecification> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public ProductSpecification addProductSpecification(ProductSpecification productSpecification) {
		getProductSpecifications().add(productSpecification);
		productSpecification.setGroupSpecification(this);

		return productSpecification;
	}

	public ProductSpecification removeProductSpecification(ProductSpecification productSpecification) {
		getProductSpecifications().remove(productSpecification);
		productSpecification.setGroupSpecification(null);

		return productSpecification;
	}

}