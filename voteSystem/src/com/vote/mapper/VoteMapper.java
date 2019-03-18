package com.vote.mapper;

import java.util.List;
import java.util.Set;

import com.vote.pojo.User;
import com.vote.pojo.Vote;

/**
 * @author: mulming
 * @ClassName: VoteMapper
 * @date: 2019年1月15日 上午9:36:18
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
public interface VoteMapper {
	public User login(User user);
	public List<User> getCampaigner();//得到所有候选人
	public void insertVote(Vote vote);//把票数加入数据库
	public List<String> getVoteCiphertextListByID(int campaignerId);
	public List<Vote> getVoteDetileByCID(int campaignerId);
	public int getUserVoteNum(String userName);//获得用户当前投票的总数（一个用户只能投2票）
	
	public Set<String> getCampaignerByVoter(String userName);//通过投票者的姓名，得到他投票的竞争者的ID
	public User getCampaignerByID(int id);//得到所有候选人

}
