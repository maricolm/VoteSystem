package com.vote.pojo;

import java.math.BigInteger;

/**
 * @author: mulming
 * @ClassName: CountVote
 * @date: 2019年1月24日 下午5:01:19
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
public class CountVote {
	private String countCiphertext;//投票总数的密文 
	private BigInteger countPlaintext;//投票总数的明文
	public String getCountCiphertext() {
		return countCiphertext;
	}
	public void setCountCiphertext(String countCiphertext) {
		this.countCiphertext = countCiphertext;
	}
	public BigInteger getCountPlaintext() {
		return countPlaintext;
	}
	public void setCountPlaintext(BigInteger countPlaintext) {
		this.countPlaintext = countPlaintext;
	}
}
