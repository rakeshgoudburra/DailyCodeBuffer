package com.mapping.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_TABLE")

public class User {
	@Id
    @GeneratedValue
    private Integer userId;

    private String userName;
    private String userPwd;

    @ManyToMany
    private List<Role> role;
    
    

}
