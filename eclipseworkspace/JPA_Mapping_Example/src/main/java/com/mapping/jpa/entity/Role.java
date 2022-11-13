package com.mapping.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_TABLE")
public class Role {
	 @Id
	 @GeneratedValue
	 private Integer roleId;

	 private String roleName;

	 @ManyToMany(mappedBy = "role")
	 
	 private List<User> user;
}
