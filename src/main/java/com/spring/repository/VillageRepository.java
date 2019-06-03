package com.spring.repository;

import com.spring.domain.Village;
import com.spring.jdbcrepository.JdbcRepository;

public interface VillageRepository extends JdbcRepository<Village, String> {

	public static final String TB_VILLAGES = "VILLAGES";
	public static final String COL_SUB_DISTRICT_CODE = "SUB_DISTRICT_CODE";
	public static final String COL_VILLAGE_NAME = "VILLAGE_NAME";
	public static final String COL_VILLAGE_NO = "VILLAGE_NO";
	public static final String COL_VILLAGE_CODE = "VILLAGE_CODE";
	public static final String SUB_DISTRICT_CODE = "VILLAGES.SUB_DISTRICT_CODE";
	public static final String VILLAGE_NAME = "VILLAGES.VILLAGE_NAME";
	public static final String VILLAGE_NO = "VILLAGES.VILLAGE_NO";
	public static final String VILLAGE_CODE = "VILLAGES.VILLAGE_CODE";
	
}
