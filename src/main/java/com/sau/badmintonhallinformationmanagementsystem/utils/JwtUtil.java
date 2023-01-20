package com.sau.badmintonhallinformationmanagementsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 * @author SRDZ
 * @date 2023/1/3 15:16
 */
public class JwtUtil {

  //七天
  private static long expire = 604800;

  private static String secret = "abcdfghiabcdfghiabcdfghiabcdfghi";

  public static String generateToken(String userName){
    Date now = new Date();
    Date expiration = new Date(now.getTime() + 1000 * expire);
    return Jwts.builder()
        .setHeaderParam("type","JWT") //JWT标头提供有关与JWT索赔相关的内容，格式和加密操作的元数据。
        .setSubject(userName) //设置sub（主题）声明
        .setIssuedAt(now) //设置iat（签发）声明
        .setExpiration(expiration) //设置exp（到期时间）声明
        .signWith(SignatureAlgorithm.HS512,secret) //指定签名密钥，并让JJWT确定指定密钥所允许的最安全算法。
        .compact();
  }

  public static Claims getClaimsByToken(String token){
    return Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .getBody();

  }
}
