package com.xupt.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// 根据用户名查询用户信息
		logger.info("登入用户名" + username);
		// 根据查找到的用户信息判断用户是否被冻结

//		return new User(username, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		String password = passwordEncoder.encode("123456");
		logger.info("password:"+password);
		return new User(username, password, true, true, true, true,
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

	}

}
