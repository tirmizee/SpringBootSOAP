package com.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.domain.Profile;
import com.spring.jdbcrepository.AbstractOracleJdbcRepository;
import com.spring.jdbcrepository.RowUnmapper;

@Repository("ProfileRepository")
public class ProfileRepositoryImpl extends AbstractOracleJdbcRepository<Profile, Long> implements ProfileRepository {

	public static final RowMapper<Profile> ROW_MAPPER = new RowMapper<Profile>() {
		@Override
		public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
			Profile profile = new Profile();
			profile.setProfileId(rs.getLong(COL_PROFILE_ID));
			profile.setUpdateDate(rs.getDate(COL_UPDATE_DATE));
			profile.setCreateDate(rs.getDate(COL_CREATE_DATE));
			profile.setLastName(rs.getString(COL_LAST_NAME));
			profile.setFirstName(rs.getString(COL_FIRST_NAME));
			profile.setEmail(rs.getString(COL_EMAIL));
			profile.setCitizenId(rs.getString(COL_CITIZEN_ID));
			profile.setSubDistrictCode(rs.getString(COL_SUB_DISTRICT_CODE));
			profile.setTel(rs.getString(COL_TEL));
			profile.setProfileImage(rs.getString(COL_PROFILE_IMAGE));
			profile.setProfileByte(rs.getBytes(COL_PROFILE_BYTE));
			return profile.withPersisted(true);
		}
	};
	
	public static final RowUnmapper<Profile> ROW_UNMAPPER = new RowUnmapper<Profile>() {
		@Override
		public Map<String, Object> mapColumns(Profile param) {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(COL_UPDATE_DATE, param.getUpdateDate());
			map.put(COL_CREATE_DATE, param.getCreateDate());
			map.put(COL_LAST_NAME, param.getLastName());
			map.put(COL_FIRST_NAME, param.getFirstName());
			map.put(COL_EMAIL, param.getEmail());
			map.put(COL_PROFILE_ID, param.getProfileId());
			map.put(COL_CITIZEN_ID, param.getCitizenId());
			map.put(COL_SUB_DISTRICT_CODE, param.getSubDistrictCode());
			map.put(COL_TEL, param.getTel());
			map.put(COL_PROFILE_IMAGE, param.getProfileImage());
			map.put(COL_PROFILE_BYTE, param.getProfileByte());
			return map;
		}
	};

	public ProfileRepositoryImpl() {
		this(TB_PROFILE);
	}
	
	public ProfileRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_PROFILE_ID);
	}

	@Override
	protected <S extends Profile> S postUpdate(S entity) {
		entity.withPersisted(true);
		return entity;
	}

	@Override
	protected <S extends Profile> S postCreate(S entity, Number generatedId) {
		entity.withPersisted(true);
		return entity;
	}

}
