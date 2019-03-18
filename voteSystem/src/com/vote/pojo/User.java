package com.vote.pojo;

import java.math.BigInteger;

/**
 * @author: mulming
 * @ClassName: VoteUser
 * @date: 2019年1月15日 上午9:34:16
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
public class User {
	private int id;//用户id
	private String name;//用户姓名
	private String pswd;//登录密码
	private int role;
	private BigInteger totalVote;//总票数
	
	public BigInteger getTotalVote() {
		return totalVote;
	}
	public void setTotalVote(BigInteger totalVote) {
		this.totalVote = totalVote;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pswd=" + pswd + ", role=" + role + "]";
	}
}
