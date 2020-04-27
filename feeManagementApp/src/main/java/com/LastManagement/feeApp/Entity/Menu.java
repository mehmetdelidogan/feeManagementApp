package com.LastManagement.feeApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="menu_id")
	private long menu_id;
	
	@Enumerated(EnumType.STRING)
	private MenuType menu_type;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role roles;


	public Menu() {
	}

	public Menu(MenuType menu_type, Role roles) {
		this.menu_type = menu_type;
		this.roles = roles;
	}

	public long getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(long menu_id) {
		this.menu_id = menu_id;
	}

	public MenuType getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(MenuType menu_type) {
		this.menu_type = menu_type;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", menu_type=" + menu_type + ", roles=" + roles + "]";
	}

}
