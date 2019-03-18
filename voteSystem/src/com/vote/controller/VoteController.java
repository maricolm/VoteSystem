package com.vote.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vote.pojo.CountVote;
import com.vote.pojo.User;
import com.vote.pojo.Vote;
import com.vote.service.VoteService;

/**
 * @author: mulming
 * @ClassName: VoteController
 * @date: 2019年1月15日 上午9:33:06
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
@Controller
@RequestMapping("/vote")
public class VoteController {
	@Autowired
	private VoteService voteService;
	
	@RequestMapping("/login.do")
	public String login(User user,HttpServletRequest req,HttpSession session) {
		User newUser=voteService.longin(user);
		if(newUser!=null) {
			if(newUser.getRole()==2) {
				session.setAttribute("user", newUser);
				//得到参加竞选的人
				List<User> campaigner=voteService.getCampaigner();
				req.setAttribute("campaigner", campaigner);
				return "index";
			}else {
				session.setAttribute("user", newUser);
				List<User> campaigner=voteService.getCampaigner();
				req.setAttribute("campaigner", campaigner);
				return "statistics";
			}
		}else {
			req.setAttribute("msg", "Your account or password is incorrect!");
			return "login/login";
		}
	}
	
	@RequestMapping("/voting.do")
	public String voting(String userName,String idNum,HttpServletRequest req,HttpSession session) {
		if(voteService.getUserVoteNum(userName)>1) {
			List<User> campaigner=voteService.getCampaignerByVoter(userName);
			if(campaigner.size()==1) {
				req.setAttribute("count", 2);
			}else {
				req.setAttribute("count", 1);
			}
			req.setAttribute("campaigner", campaigner);
			req.setAttribute("msg", "Your vote has been capped");
			return "index";
		}else {
			voteService.voting(userName, idNum);
			List<User> campaigner=voteService.getCampaigner();
			req.setAttribute("campaigner", campaigner);
			req.setAttribute("idNum", idNum);
			return "index";
		}
	}
	
	@RequestMapping("/votingDetile.do")
	public String votingDetile(int campaignerId,HttpServletRequest req) {
		List<Vote> voted=voteService.getVoteDetileByCID(campaignerId);
		CountVote countVote=voteService.getUserCountVoteByCID(campaignerId);
		req.setAttribute("voted", voted);
		req.setAttribute("countVote", countVote);
		return "detailOfVote";
	}
	
	

}
