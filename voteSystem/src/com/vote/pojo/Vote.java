package com.vote.pojo;

import java.util.List;

/**
 * @author: mulming
 * @ClassName: Vote
 * @date: 2019年1月15日 下午2:46:06
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
public class Vote {
	private int id;
	private int campaignerId;//参投人ID
	private String voteUser;//投票者
	private String voteCiphertext;//投票密文 
	private String votePlaintext;//投票明文
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCampaignerId() {
		return campaignerId;
	}
	public void setCampaignerId(int campaignerId) {
		this.campaignerId = campaignerId;
	}
	public String getVoteUser() {
		return voteUser;
	}
	public void setVoteUser(String voteUser) {
		this.voteUser = voteUser;
	}
	public String getVoteCiphertext() {
		return voteCiphertext;
	}
	public void setVoteCiphertext(String voteCiphertext) {
		this.voteCiphertext = voteCiphertext;
	}
	public String getVotePlaintext() {
		return votePlaintext;
	}
	public void setVotePlaintext(String votePlaintext) {
		this.votePlaintext = votePlaintext;
	}
	@Override
	public String toString() {
		return "Vote [id=" + id + ", campaignerId=" + campaignerId + ", voteUser=" + voteUser + ", voteCiphertext="
				+ voteCiphertext + ", votePlaintext=" + votePlaintext + "]";
	}
}
