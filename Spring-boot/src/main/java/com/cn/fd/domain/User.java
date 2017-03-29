/**
 * 
 */
package com.cn.fd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月13日 下午6:05:51
 */
@Entity
@Table(name="tb_user")
public class User {
	
	 public enum ROLE{
	        admin, user;
	 }
	    
	@Enumerated(EnumType.STRING)
	private ROLE role;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	public ROLE getRole() {
		return role;
	}

	public void setRole(ROLE role) {
		this.role = role;
	}

	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}

	public User() {
		super();
	}

	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
