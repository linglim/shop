package com.example.shop.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    @CreatedDate
    @JsonIgnore 
    private Date createdDate;
    
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    @LastModifiedDate
    @JsonIgnore 
    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreateTime(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateTime() {
        return modifyDate;
    }

    public void setUpdateTime(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
