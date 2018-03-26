package com.example.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/**
 * The persistent class for the authorization database table.
 * 
 */

@Entity
@Table(name="authorization")
@NamedQuery(name="Authorization.findAll", query="SELECT a FROM Authorization a")
public class Authorization extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	//权限名
	@Column(name="name")
	private String name;
	public Authorization() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	


}