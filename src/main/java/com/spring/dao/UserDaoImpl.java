package com.spring.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.spring.bean.UserBean;
import com.spring.repository.ProfileRepository;
import com.spring.repository.UserRepositoryImpl;

@Repository 
public class UserDaoImpl extends UserRepositoryImpl implements UserDao {

	@Override
	public UserBean findByUserId(Long userId) {
		try {
			StringBuilder statement = new StringBuilder()
				.append(" SELECT ")
				.append(USER_ID).append(" , ")
				.append(USERNAME).append(" , ")
				.append(ProfileRepository.CITIZEN_ID).append(" , ")
				.append(ProfileRepository.FIRST_NAME).append(" , ")
				.append(ProfileRepository.LAST_NAME).append(" , ")
				.append(ProfileRepository.TEL).append(" , ")
				.append(ProfileRepository.EMAIL).append(" , ")
				.append(ProfileRepository.BRANCH_CODE)
				.append(" FROM ").append(TB_USERS)
				.append(" INNER JOIN ").append(ProfileRepository.TB_PROFILE)
				.append(" ON ").append(PROFILE_ID)
				.append(" = ").append(ProfileRepository.PROFILE_ID)
				.append(" WHERE ").append(USER_ID).append(" = ? ");
			return getJdbcOps().queryForObject(statement.toString(), params(userId), new BeanPropertyRowMapper<>(UserBean.class));
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

}
