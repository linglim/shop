package com.example.shop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    protected Long id;
	@Column(name="name")
    private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//private List<User> user;
	
    
//	 public Long getId() {
//	        return id;
//	}
//
//	public void setId(Long id) {
//	       this.id = id;
//	}
}
