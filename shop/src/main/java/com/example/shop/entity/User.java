package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique=true, nullable=false)
//	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="created_at")
//	private Date createdAt;
	@JsonIgnore
	@Column(length=255)
	private String email;
	
	@Column(length=255)
	private String name;
	@JsonIgnore
	@Column(length=11)
	private String phone;
	
	@JsonIgnore
	@Column(length=11)
	private String password;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="updated_at")
//	private Date updatedAt;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="role_id")
	private Role role;
	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//bi-directional many-to-one association to Authorization
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Authorization> authorizations;

	public User() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public Date getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public List<Authorization> getAuthorizations() {
		return this.authorizations;
	}

	public void setAuthorizations(List<Authorization> authorizations) {
		this.authorizations = authorizations;
	}

//	public Authorization addAuthorization(Authorization authorization) {
//		getAuthorizations().add(authorization);
//		authorization.setUser(this);
//
//		return authorization;
//	}
//
//	public Authorization removeAuthorization(Authorization authorization) {
//		getAuthorizations().remove(authorization);
//		authorization.setUser(null);
//
//		return authorization;
//	}

}