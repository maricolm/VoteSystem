package com.vote.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.vote.unit.Paillier;

/**
 * @author: mulming
 * @ClassName: VoteTest
 * @date: 2019年1月15日 上午10:30:13
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
class VoteTest {

	@Test
	void test() {
		 /* instantiating an object of Paillier cryptosystem*/
        Paillier paillier = new Paillier();
        /* instantiating two plaintext msgs*/
        BigInteger m1 = new BigInteger("1");
        BigInteger m2 = new BigInteger("0");
        BigInteger m3 = new BigInteger("0");
        BigInteger m4 = new BigInteger("0");
        /* encryption*/
//***********************************
        long startTime=System.nanoTime(); //获取开始时间
//***********************************
        BigInteger em1 = paillier.Encryption(m1); //密文	1
        BigInteger em2 = paillier.Encryption(m2); //密文	2
        BigInteger em3 = paillier.Encryption(m3); //密文	3
        BigInteger em4 = paillier.Encryption(m4); //密文	4
        System.out.println("em1==="+em1);
        System.out.println("em2==="+em2);
        System.out.println("em3==="+em3);
        System.out.println("em4=="+em4);
//***********************************
        BigInteger product_em1em2 = em1.multiply(em2).multiply(em2).multiply(em2).mod(paillier.nsquare);
        System.out.println("decrypted sum: " + paillier.Decryption(product_em1em2).toString());
      long endTime=System.nanoTime(); //获取结束时间
      System.out.println("Encryption Time： "+(endTime-startTime)/Math.pow(10,6)+"ms");
	}
	
	@Test
	public void testGetclass(){
		//this.getClass().getClassLoader().getResourceAsStream("para.properties")
		System.out.println(this.getClass().getClassLoader().toString());
	}

}
