package com.vote.service;

import java.util.List;
import java.util.Set;

import com.vote.pojo.CountVote;
import com.vote.pojo.User;
import com.vote.pojo.Vote;

/**
 * @author: mulming
 * @ClassName: VoteService
 * @date: 2019年1月15日 上午9:35:27
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
public interface VoteService {
	public User longin(User user);//登录
	public List<User> getCampaigner();//获取候选人
	public void voting(String userName,String idNum);//投票
	public List<Vote> getVoteDetileByCID(int campaignerId);
	public int getUserVoteNum(String userName);//获得用户当前投票的总数（一个用户只能投2票）
	public CountVote getUserCountVoteByCID(int campaignerId);
	
	public List<User> getCampaignerByVoter(String userName);//通过投票者的姓名，得到他投票的竞争者的ID
}
