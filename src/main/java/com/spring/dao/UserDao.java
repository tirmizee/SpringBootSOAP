package com.spring.dao;

import com.spring.bean.UserBean;
import com.spring.repository.UserRepository;

public interface UserDao extends UserRepository {

	UserBean findByUserId(Long userId);
	
}
