package com.portal.model.domain;
// Generated Dec 20, 2013 4:48:43 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users")
public class Users implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	private Roles roles;
	private String name;
	private Integer phone;
	private Date birth;
	private String login;
	private String password;
	private short enabled;

	public Users() {
	}

	public Users(int code, short enabled) {
		this.code = code;
		this.enabled = enabled;
	}

	public Users(int code, Roles roles, String name, Integer phone, Date birth,
			String login, String password, short enabled) {
		this.code = code;
		this.roles = roles;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.login = login;
		this.password = password;
		this.enabled = enabled;
	}

	@Id
	@Column(name = "code", unique = true, nullable = false)
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codrol")
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone")
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth", length = 13)
	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Column(name = "login")
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public short getEnabled() {
		return this.enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

}
