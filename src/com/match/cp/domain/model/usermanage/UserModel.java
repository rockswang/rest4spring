package com.match.cp.domain.model.usermanage;

import java.util.List;

import com.match.cp.framework.model.AbstractModel;
import com.match.cp.framework.model.Model;

public class UserModel extends AbstractModel implements Model{
	private long id;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private List<RoleModel> roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	} 
}
