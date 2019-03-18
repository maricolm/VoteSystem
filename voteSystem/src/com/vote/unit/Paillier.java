package com.vote.unit;

/**
 * @author: mulming
 * @ClassName: Paillier
 * @date: 2019年1月15日 上午10:25:40
 * @Description:TODO(这里用一句话描述这个类的作用)
 */
import java.math.*;
import java.util.*;

public class Paillier {
	
	//公钥 n g
	//私钥 lambda u
    /**
     * p and q are two large primes. 
     * lambda = lcm(p-1, q-1) = (p-1)*(q-1)/gcd(p-1, q-1).  最小公倍数
     */
    private BigInteger p,  q,  lambda;
    public BigInteger n;//n = p*q, where p and q are two large primes.
    public BigInteger nsquare;//nsquare = n*n
    private BigInteger g;//a random integer in Z*_{n^2} where gcd (L(g^lambda mod n^2), n) = 1.
    private int bitLength=512;

    /**
     * Constructs an instance of the Paillier cryptosystem with 512 bits of modulus and at least 1-2^(-64) certainty of primes generation.
     */
    public Paillier() {
      //  KeyGeneration(512,64);
    	try {
    		Properties properties = new Properties();
    		properties.load(this.getClass().getClassLoader().getResourceAsStream("para.properties"));
    		//lambda =new BigInteger(properties.getProperty("lambda"));
    		p=new BigInteger(properties.getProperty("p"));
    		q=new BigInteger(properties.getProperty("q"));
    		n = p.multiply(q);
    	    nsquare = n.multiply(n);
    	    lambda = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)).divide(
                    p.subtract(BigInteger.ONE).gcd(q.subtract(BigInteger.ONE)));
    		//n=new BigInteger(properties.getProperty("n"));
    		//nsquare=new BigInteger(properties.getProperty("nsquare"));
    		g = new BigInteger("2");
    		/* check whether g is good.*/
    		if (g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).gcd(n).intValue() != 1) {
                System.out.println("g is not good. Choose g again.");
                System.exit(1);
            }
		} catch (Exception e) {}
    }
	
   //加密
    public BigInteger Encryption(BigInteger m) {
        BigInteger r = new BigInteger(bitLength, new Random());
        return g.modPow(m, nsquare).multiply(r.modPow(n, nsquare)).mod(nsquare);
    }
    //解密
    public BigInteger Decryption(BigInteger c) {
        BigInteger u = g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).modInverse(n);// 计算u
        return c.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).multiply(u).mod(n);
    }
}
