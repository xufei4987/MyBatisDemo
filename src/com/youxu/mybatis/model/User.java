package com.youxu.mybatis.model;

public class User {
	private int id;
	private String nick;// 用户姓名
	private String phone;// 电话
	private String address;// 地址
	private String email;// 邮箱
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nick=" + nick + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ "]";
	}
	
	

}
