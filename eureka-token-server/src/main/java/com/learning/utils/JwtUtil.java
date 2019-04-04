package com.learning.utils;

import com.learning.entity.dto.UserDto;
import com.learning.enumerate.ParseToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title null.java$
 * @ClassName JwtUtil
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/22 13:17
 * @Version 1.0
 */
public class JwtUtil {

	/**
	 * token 加密算法 HS256
	 **/
	private final static SignatureAlgorithm ENCRYPT_KEY = SignatureAlgorithm.HS256;

	/**
	 * 该JWT 所面向的用户
	 **/
	private final static String SUBJECT = "dew";

	/**
	 * 私钥
	 **/
	private final static String SECRET_KEY = "secretkey";

	/**
	 * @param uid 用户id
	 * @param name 用户名
	 * @param duration 有效时长(unix时间戳)
	 * @return java.lang.String
	 * @Title createJws
	 * @Description
	 * @Param
	 **/
	public static String createJws(Long uid, String name, String password, long duration) {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// 自定义token携带的参数值
		Map<String, Object> claims = new HashMap<>();
		claims.put("uid", uid);
		claims.put("user_name", name);
//		claims.put("password", password);

		JwtBuilder builder = Jwts.builder()
				                     // 该JWT 所面向的用户
				                     .setSubject(SUBJECT)
				                     // token 携带的参数
				                     .setClaims(claims)
				                     // token创建时间,unix时间戳格式
				                     .setIssuedAt(now)
				                     .signWith(ENCRYPT_KEY, SECRET_KEY);
		if (duration >= 0) {
			// 设置最大有效时间,unix时间戳
			long expirationMills = nowMillis + duration;
			Date expirationTime = new Date(expirationMills);
			//expire 指定 token 的声明周期,unix 时间戳格式
			builder.setExpiration(expirationTime);
		}

		return builder.compact();
	}

	/**
	 * @return java.lang.Object
	 * @Title analysisToken
	 * @Description 解析 Token 内容信息
	 * @Param
	 **/
	public static Object analysisToken(String token, ParseToken type) {

		try {
			// 解析 token 中携带的信息
			Claims claims = parseJWs(token);

			long now = System.currentTimeMillis();
			// token 失效时间(设置的过期时间为 java.util.Date)
			Date expDate = claims.get("exp", Date.class);
			long exp = expDate.getTime();
			// 用户编号
			Long uid = claims.get("uid", Long.class);
			// 登录名
			String userName = claims.get("user_name", String.class);

			// 1.token 过期
			if (exp < now) {
				throw new JwtException("Token 过期");
			}
			// 2.在有效期内,刷新 token
			switch (type) {
				case UID:
					return uid;
				case USER_DTO:
					UserDto userDto = new UserDto(token, uid, userName);
					exp = now + new UserDto().getExpritaion();
					userDto.setExpritaion(exp);
					return userDto;
				case USER_NAME:
					return userName;
				default:
					break;
			}

		} catch (JwtException e) {
			throw new JwtException(e.getMessage());
		} catch (Exception exception) {
			throw new RuntimeException("token解析错误");
		}
		return false;
	}

	/**
	 * @return io.jsonwebtoken.Claims
	 * @Title parseJWs
	 * @Description 解析 token 字符串
	 * @Param
	 **/
	static Claims parseJWs(String token) throws JwtException {
		// 解析 token 中携带的信息
		Claims claims = Jwts.parser()
				                .setSigningKey(SECRET_KEY)
				                .parseClaimsJws(token)
				                .getBody();

		return claims;
	}

}