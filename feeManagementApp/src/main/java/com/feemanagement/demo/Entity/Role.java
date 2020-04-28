package com.feemanagement.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private long role_id;
	
	@Enumerated(EnumType.STRING)
	private RoleType role_type;

	@ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	private List<User> users;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	private List<Menu> menu;

	
	public Role() {
	}
	
	public Role(RoleType role_type, List<User> users, List<Menu> menu) {
		this.role_type = role_type;
		this.users = users;
		this.menu = menu;
	}

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	public RoleType getRole_type() {
		return role_type;
	}

	public void setRole_type(RoleType role_type) {
		this.role_type = role_type;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_type=" + role_type + ", users=" + users + ", menu=" + menu + "]";
	}

}
