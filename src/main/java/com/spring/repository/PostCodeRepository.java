package com.spring.repository;

import com.spring.domain.PostCode;
import com.spring.jdbcrepository.JdbcRepository;

public interface PostCodeRepository extends JdbcRepository<PostCode, Integer> {
	
	public static final String TB_POSTCODE = "POSTCODE";
	public static final String COL_ZIPCODE = "ZIPCODE";
	public static final String COL_SUB_DISTRICT_CODE = "SUB_DISTRICT_CODE";
	public static final String COL_POST_CODE_ID = "POST_CODE_ID";
	public static final String ZIPCODE = "POSTCODE.ZIPCODE";
	public static final String SUB_DISTRICT_CODE = "POSTCODE.SUB_DISTRICT_CODE";
	public static final String POST_CODE_ID = "POSTCODE.POST_CODE_ID";

}
