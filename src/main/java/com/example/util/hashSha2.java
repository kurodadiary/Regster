package com.example.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.util.DigestUtils;

public class hashSha2 {
	
	public String convertToSha256(String pass) throws NoSuchAlgorithmException{
		String passToSha256 = "";
        //ハッシュ生成前にバイト配列に置き換える際のCharset
        Charset charset = StandardCharsets.UTF_8;
        //ハッシュアルゴリズム
        String algorithm = "SHA-256";

        //ハッシュ生成処理
        byte[] bytes = MessageDigest.getInstance(algorithm).digest(pass.getBytes(charset));
        passToSha256 = DatatypeConverter.printHexBinary(bytes);
	return passToSha256;
	};

};
