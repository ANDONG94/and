package com.example.and.RsaSignatureDemo;

import org.junit.Test;

import java.security.*;
import java.util.Base64;

/**
 * @program: and
 * @description: java数字签名
 * @author: and
 * @create: 2020-09-01 11:25
 **/
public class RsaSignatureDemo {
    /**
     * RSA数字签名算法主要分为MD系列和SHA系列两大类。
     * MD系列主要包括MD2withRSA和MD5withRSA共2种数字签名算法
     * ；SHA系列主要包括SHA1withRSA、SHA224withRSA、
     * SHA256withRSA、SHA384withRSA和SHA512withRSA共5种数字签名算法。
     */
    @Test
    public  void RSA() throws Exception {
        String value = "mrbird's blog";
        // 非对称加密算法
        String algorithm = "RSA";
        // 签名算法，RSA+SHA
        String signAlgorithm = "SHA256withRSA";

        // ----- 公私钥生成 --------
        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 初始化，秘钥长度512~16384位，64倍数
        keyPairGenerator.initialize(512);
        // 生成秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 公钥
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("RSA公钥: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("RSA私钥: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // ----- 私钥加签 ---------
        // 获取签名对象
        Signature signature = Signature.getInstance(signAlgorithm);
        signature.initSign(privateKey);
        signature.update(value.getBytes());
        byte[] sign = signature.sign();
        System.out.println("签名值: " + Base64.getEncoder().encodeToString(sign));

        // ----- 公钥验签 ---------
        signature.initVerify(publicKey);
        signature.update(value.getBytes());
        System.out.println("验签结果: " + signature.verify(sign));

    }

    /**
     *DSA算法与RSA算法都是数字证书中不可或缺的两种算法。两者不同的是，DSA算法仅包含数字签名算法，
     * 使用DSA算法的数字证书无法进行加密通信，而RSA算法既包含加密/解密算法，同时兼有数字签名算法。
     *
     * JDK8支持SHA1withDSA、SHA224withDSA、SHA256withDSA、
     * SHA384withDSA和SHA512withDSA这五种DSA数字签名算法。
     *
     * 代码示例（只需将上面的例子算法替换下就好，并且注意秘钥的长度范围）：
     * @throws Exception
     */
    @Test
    public void DSA() throws Exception {
        String value = "mrbird's blog";
        // 非对称加密算法
        String algorithm = "DSA";
        // 签名算法，DSA+SHA
        String signAlgorithm = "SHA224withDSA";

        // ----- 公私钥生成 --------
        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 初始化，秘钥长度512~1024位，64倍数
        keyPairGenerator.initialize(1024);
        // 生成秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 公钥
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("DSA公钥: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("DSA私钥: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // ----- 私钥加签 ---------
        // 获取签名对象
        Signature signature = Signature.getInstance(signAlgorithm);
        signature.initSign(privateKey);
        signature.update(value.getBytes());
        byte[] sign = signature.sign();
        System.out.println("签名值: " + Base64.getEncoder().encodeToString(sign));

        // ----- 公钥验签 ---------
        signature.initVerify(publicKey);
        signature.update(value.getBytes());
        System.out.println("验签结果: " + signature.verify(sign));

    }
}
