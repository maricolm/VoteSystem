package com.vote.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.mapper.VoteMapper;
import com.vote.pojo.CountVote;
import com.vote.pojo.User;
import com.vote.pojo.Vote;
import com.vote.service.VoteService;
import com.vote.unit.Paillier;

import javassist.bytecode.Descriptor.Iterator;

/**
 * @author: mulming
 * @ClassName: VoteServiceImpl
 * @date: 2019年1月15日 上午9:35:49
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
@Service
public class VoteServiceImpl implements VoteService {
	@Autowired
	private VoteMapper voteMapper;

	@Override
	public User longin(User user) {
		return voteMapper.login(user);
	}

	@Override
	public List<User> getCampaigner() {
		Paillier paillier = new Paillier();
		List<User> campaigner=voteMapper.getCampaigner();
		//TODO 封装票数
		for(int i=0;i<campaigner.size();i++) {
			List<String> cipText=voteMapper.getVoteCiphertextListByID(campaigner.get(i).getId());
			if(cipText.size()==1) {
				BigInteger votenum=paillier.Decryption(new BigInteger(cipText.get(0)));
				campaigner.get(i).setTotalVote(votenum);
			}else if(cipText.size()>1) {
				BigInteger votenum=new BigInteger(cipText.get(0));
				for(int j=1;j<cipText.size();j++) {
					votenum=votenum.multiply(new BigInteger(cipText.get(j)));
				}
				votenum=paillier.Decryption(votenum);
				campaigner.get(i).setTotalVote(votenum);
			}
		}
		return campaigner;
	}

	@Override
	public void voting(String userName, String idNum) {
		Paillier paillier = new Paillier();
		//1、得到所有的候选人
		List<User> campaigner=voteMapper.getCampaigner();
		//2、如果ID不是投票的id则投票数为0.
		for(int i=0;i<campaigner.size();i++) {
			if(campaigner.get(i).getId()==Integer.parseInt(idNum)) {
				BigInteger m1 = new BigInteger("1");
				BigInteger em1 = paillier.Encryption(m1);
				Vote vote=new Vote();
				vote.setCampaignerId(campaigner.get(i).getId());
				vote.setVoteUser(userName);
				vote.setVoteCiphertext(em1.toString());
				vote.setVotePlaintext("1");
				voteMapper.insertVote(vote);
			}else {
				BigInteger m1 = new BigInteger("0");
				BigInteger em1 = paillier.Encryption(m1);
				Vote vote=new Vote();
				vote.setCampaignerId(campaigner.get(i).getId());
				vote.setVoteUser(userName);
				vote.setVoteCiphertext(em1.toString());
				vote.setVotePlaintext("0");
				voteMapper.insertVote(vote);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.vote.service.VoteService#getVoteDetileByCID(java.lang.String)
	 */
	@Override
	public List<Vote> getVoteDetileByCID(int campaignerId) {
		return voteMapper.getVoteDetileByCID(campaignerId);
	}

	@Override
	public int getUserVoteNum(String userName) {
		return voteMapper.getUserVoteNum(userName);
	}

	
	@Override
	public CountVote getUserCountVoteByCID(int campaignerId) {
		Paillier paillier = new Paillier();
		CountVote countVote=new CountVote();
		List<Vote> voteOfUser=voteMapper.getVoteDetileByCID(campaignerId);
		if(voteOfUser.size()==1) {
			BigInteger votenum=paillier.Decryption(new BigInteger(voteOfUser.get(0).getVoteCiphertext()));
			countVote.setCountCiphertext(voteOfUser.get(0).getVoteCiphertext());
			countVote.setCountPlaintext(votenum);
		}else if(voteOfUser.size()>1) {
			BigInteger votenum=new BigInteger(voteOfUser.get(0).getVoteCiphertext());
			for(int j=1;j<voteOfUser.size();j++) {
				votenum=votenum.multiply(new BigInteger(voteOfUser.get(j).getVoteCiphertext()));
			}
			countVote.setCountCiphertext(votenum.toString());
			votenum=paillier.Decryption(votenum);
			countVote.setCountPlaintext(votenum);
		}
		return countVote;
	}

	/* (non-Javadoc)
	 * @see com.vote.service.VoteService#getCampaignerByVoter(java.lang.String)
	 */
	@Override
	public List<User> getCampaignerByVoter(String userName) {
		Set<String> cId=voteMapper.getCampaignerByVoter(userName);
		List<User> user=new ArrayList<User>();
		for(String i:cId) {
			user.add(voteMapper.getCampaignerByID(Integer.parseInt(i)));
		}
		return user;
	}

}
